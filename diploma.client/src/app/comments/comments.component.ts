import {Component, Inject, OnInit} from '@angular/core';
import {OrderService} from "../orders/shared/order.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {LanguagesService} from "../shared/languages.service";
import {ItemService} from "../orders/shared/item.service";
import {DOCUMENT} from "@angular/platform-browser";
import {Comments} from "../../model/comments.model";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              public dialogRef: MatDialogRef<CommentsComponent>,
              private itemService: ItemService,
              private orderService: OrderService,
              public languagesService: LanguagesService,
              @Inject(DOCUMENT) private document: Document) {
  }

  windowScrolled: boolean;

  public comments: Array<Comments>;

  ngOnInit() {
    this.comments = this.data.comments as Array<Comments>;
  }

  onSubmit() {

  }

  scrollDown() {
    event.preventDefault()
    document.getElementById('downpage').scrollIntoView()
  }

}
