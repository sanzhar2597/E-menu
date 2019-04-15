import {Component, OnInit} from '@angular/core';
import {BookingService} from "../shared/booking.service";
import {Table} from "../../model/table.model";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {NextOperationComponent} from "../next-operation/next-operation.component";
import {LoginService} from "../login/login.service";
import {Router} from "@angular/router";
import {AlertComponent} from "../alert/alert.component";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  loading: boolean = false;

  constructor(private bookingService: BookingService,
              private dialog: MatDialog,
              private login: LoginService,
              private router: Router) {
  }

  ngOnInit() {
    this.resetForm();
    this.loading = true;
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
      tableType: Table.CENTER,
      phoneNumber: "8707",
      customerId: "",
    }
  }

  onSubmit() {
    event.preventDefault();
    let self = this;
    console.log(this.bookingService.booking)
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    dialogConfig.data = {lego: "nazar"}
    this.dialog.open(NextOperationComponent, dialogConfig).afterClosed().subscribe(res => {
      switch (res) {
        case "orderComponent":
          this.router.navigate(['/order']);
          break;
        case "submit":
          self.bookingService.checkTime().then(value => {
            this.showResponseAlert(value.body);
          });
          break;
      }

      console.log("SUBSCRIBED")
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
        case "full":
          break;
        case "empty":
          this.resetForm();
          this.getPhoneNumber();
          break;
      }
    });
  }

  getPhoneNumber() {
    this.login.getPersonDisplay().then(value1 => {
      this.loading = false;
      if (value1.username) {
        this.bookingService.booking.phoneNumber = value1.username;
      }
    });
  }


}
