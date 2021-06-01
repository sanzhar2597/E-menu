import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { BookingService } from '../shared/booking.service';
import { NgForm } from '@angular/forms';
import { LanguagesService } from '../shared/languages.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {

  public alertText = this.languagesService.languages.waitresponse;
  public isLoading = true;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              public dialogRef: MatDialogRef<AlertComponent>,
              private bookingService: BookingService,
              public languagesService: LanguagesService) {
  }


  ngOnInit() {
    this.showAlertText();
  }

  showAlertText() {
    if (this.data.response == this.languagesService.languages.full) {
      this.isLoading = false;
      this.alertText = this.languagesService.languages.placetaken;
    }
    if (this.data.response == this.languagesService.languages.empty) {
      this.saveBooking();
    }
  }

  saveBooking() {
    this.bookingService.saveBooking().then(res => {
      this.alertText = this.languagesService.languages.successbooked;
      this.isLoading = false;
    });
  }

  close() {
    this.dialogRef.close(this.data.response);
  }

  onSubmit(form: NgForm) {
    event.preventDefault();
  }

  printing() {
    window.print();
  }
}


