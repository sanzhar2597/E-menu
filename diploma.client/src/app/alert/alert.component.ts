import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {BookingService} from "../shared/booking.service";

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {

  public alertText = "Ждите ответа";
  public isLoading = true;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              public dialogRef: MatDialogRef<AlertComponent>,
              private bookingService: BookingService) {
  }


  ngOnInit() {
    this.showAlertText();
  }

  showAlertText() {
    if (this.data.response == "full") {
      this.isLoading = false;
      this.alertText = "Место занято";
    }
    if (this.data.response == "empty") {
      this.saveBooking()
    }
  }

  saveBooking() {
    this.bookingService.saveBooking().then(res => {
      this.alertText = "Успешно забронирован";
      this.isLoading = false;
    })
  }

  close() {
    this.dialogRef.close(this.data.response);
  }
}


