import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {BookingService} from "../shared/booking.service";

@Component({
  selector: 'app-next-operation',
  templateUrl: './next-operation.component.html',
  styleUrls: ['./next-operation.component.css']
})
export class NextOperationComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    public dialogRef: MatDialogRef<NextOperationComponent>,
    private bookingService: BookingService
  ) {
  }


  ngOnInit() {
  }

  enableTable() {
    if (this.data.response == "full") {
      return false
    }
    else if (this.data.response == "empty") {
      return true
    }
    return false;
  }

  openOrderComponent() {
    this.dialogRef.close("orderComponent");
  }

  onSubmit() {
    this.dialogRef.close("submit");
  }
  close(){
    this.dialogRef.close();
  }
}
