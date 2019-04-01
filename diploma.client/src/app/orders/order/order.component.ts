import {Component, OnInit} from '@angular/core';
import {OrderService} from "../shared/order.service";
import {NgForm} from "@angular/forms";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {OrderItemsComponent} from "../order-items/order-items.component";
import {ItemService} from "../shared/item.service";
import {OrderItem} from "../../../model/orderItem.model";
import {Item} from "../../../model/item.model";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styles: []
})
export class OrderComponent implements OnInit {

  formData: OrderItem;
  itemList: Item[];

  constructor(private service: OrderService,
              private dialog: MatDialog,
              private itemService: ItemService) {
  }

  ngOnInit() {
    this.resetForm()
    this.itemService.getItemList()
      .then(res => {
        console.log("LALALAL");
        for (var key in res) {
          this.itemList.push(res[key])
        }
      })
      .catch(e => console.log("NAZAR: ", e))

  }

  resetForm(form?: NgForm) {
    if (form === null)
      form.resetForm();
    this.service.formData = {
      orderId: 0,
      orderNo: Math.floor(100000 + Math.random() * 900000).toString(),
      customerId: 0,
      pMethod: '',
      gTotal: 0
    };
    this.service.orderItems = []
  }

  addOrEditOrderItem(orderItemIndex, orderId) {
    event.preventDefault();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = "50%";
    dialogConfig.data = {orderItemIndex, orderId}
    this.dialog.open(OrderItemsComponent, dialogConfig)
  }

  onDeleteOrderItem(orderItemId: number, i: number) {
    event.preventDefault();
    this.service.orderItems.splice(i, 1)
  }
}
