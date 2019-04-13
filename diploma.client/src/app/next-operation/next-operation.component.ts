import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-next-operation',
  templateUrl: './next-operation.component.html',
  styleUrls: ['./next-operation.component.css']
})
export class NextOperationComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    public dialogRef: MatDialogRef<NextOperationComponent>,
  ) {
  }


  ngOnInit() {
  }

  openOrderComponent() {
    this.dialogRef.close("Nazar");
  }
}
