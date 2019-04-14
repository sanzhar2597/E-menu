import {Component, OnInit} from '@angular/core';
import {BookingService} from "../shared/booking.service";
import {Table} from "../../model/table.model";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {NextOperationComponent} from "../next-operation/next-operation.component";
import {LoginService} from "../login/login.service";
import {Router} from "@angular/router";

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
          self.bookingService.saveBooking().then(res => {
            console.log("BOOKING CHECK-TIME: ", res);
            this.resetForm();
            this.getPhoneNumber();
            /*this.bookingService.saveBooking().then(res=>{

            });*/
          })
          break;
      }

      console.log("SUBSCRIBED")
    })
  }

  getPhoneNumber() {
    this.login.getPersonDisplay().then(value1 => {
      this.loading = false;
      this.bookingService.booking.phoneNumber = value1.username;
    });
  }


}
