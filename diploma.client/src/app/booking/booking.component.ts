import {Component, OnInit} from '@angular/core';
import {BookingService} from "../shared/booking.service";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {NextOperationComponent} from "../next-operation/next-operation.component";
import {LoginService} from "../login/login.service";
import {Router} from "@angular/router";
import {AlertComponent} from "../alert/alert.component";
import {NgForm} from "@angular/forms";
import {LanguagesService} from "../shared/languages.service";
import {TableSelectionComponent} from "../table-selection/table-selection.component";

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
    this.bookingService.getRestaurantTable().then(value => {
        this.bookingService.table = value.body
        this.resetForm();
      }
    )
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
      personId: "",
    }
    this.userForLocalStorage()
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

        this.bookingService.getPersonId(value1.username).then(value => {
          this.bookingService.booking.personId = value.body
        })
      }
      else {
        this.userForLocalStorage()
      }

    });
  }

  userForLocalStorage() {
    let person: any = JSON.parse(localStorage.getItem('person'))
    if (!this.bookingService.booking.personId) {
      this.bookingService.booking.personId = person.id
    }
  }

  selectTable() {
    let scope = this
    console.log(this.bookingService.table)
    console.log(this.bookingService.booking.tableType)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "80%";
    dialogConfig.height = "60%";
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = false;
    dialogConfig.data = {
      count: scope.bookingService.table.length,
      response: scope.bookingService.table.findIndex(value => value == scope.bookingService.booking.tableType)
    }
    this.dialog.open(TableSelectionComponent, dialogConfig).afterClosed().subscribe(res => {
      if (res != undefined) {
        this.bookingService.booking.tableType = this.bookingService.table[+res]
      }
      else {
        this.bookingService.booking.tableType = this.bookingService.table[0]
      }
    });
  }


}
