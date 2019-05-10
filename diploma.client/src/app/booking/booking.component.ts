import {Component, OnInit} from '@angular/core';
import {BookingService} from "../shared/booking.service";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {NextOperationComponent} from "../next-operation/next-operation.component";
import {LoginService} from "../login/login.service";
import {Router} from "@angular/router";
import {AlertComponent} from "../alert/alert.component";
import {NgForm} from "@angular/forms";
import {LanguagesService} from "../shared/languages.service";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {


  public isRegisteredClient = false;

  constructor(public bookingService: BookingService,
              private dialog: MatDialog,
              private login: LoginService,
              private router: Router,
              public languagesService: LanguagesService) {
  }

  ngOnInit() {
    this.resetForm();
    this.getPhoneNumber();

  }


  resetForm() {
    this.bookingService.booking = {
      bookingId: Math.floor(100000 + Math.random() * 900000),
      numberOfPeople: 1,
      recordTime: new Date(),
      recordDateDay: "2019-05-05",
      recordDateFrom: "12:00",
      recordDateTo: "12:00",
      tableType: this.bookingService.table.length ? this.bookingService.table[0] : "",
      phoneNumber: "8707",
      customerId: "",
    }
  }

  onSubmit(form: NgForm) {
    event.preventDefault();
    let self = this;
    console.log(this.bookingService.booking)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    this.login.preloader = true;
    self.bookingService.checkTime().then(value => {
      this.login.preloader = false;
      dialogConfig.data = {response: value.body};
      this.dialog.open(NextOperationComponent, dialogConfig).afterClosed().subscribe(res => {
        switch (res) {
          case "orderComponent":
            this.bookingService.saveBooking().then(res => {
              this.router.navigate(['/order']);
            })
            break;
          case "submit":
            self.bookingService.checkTime().then(value => {
              this.showResponseAlert(value.body);
            });
            break;
          default:
            break;
        }

      })
    })

  }

  showResponseAlert(response) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    dialogConfig.data = {response: response}
    this.dialog.open(AlertComponent, dialogConfig).afterClosed().subscribe(res => {

      switch (res) {
        case this.languagesService.languages.full:
          break;
        case this.languagesService.languages.empty:
          this.resetForm();
          this.getPhoneNumber();
          break;
      }
    });
  }

  getPhoneNumber() {
    this.login.preloader = true;
    this.login.getPersonDisplay().then(value1 => {
      this.login.preloader = false;
      if (value1.username) {
        this.isRegisteredClient = true;
        this.bookingService.booking.phoneNumber = value1.username;
      }
    });
  }


}
