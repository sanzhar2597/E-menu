///<reference path="../../../model/item.model.ts"/>
import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {OrderItem} from "../../../model/orderItem.model";
import {ItemService} from "../shared/item.service";
import {Item} from "../../../model/item.model";
import {NgForm} from "@angular/forms";
import {OrderService} from "../shared/order.service";

@Component({
  selector: 'app-order-items',
  templateUrl: './order-items.component.html',
  styles: []
})
export class OrderItemsComponent implements OnInit {
  formData: OrderItem;
  itemList: Item[];
  isValid: boolean = true;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data,
    public dialogRef: MatDialogRef<OrderItemsComponent>,
    private itemService: ItemService,
    private orderService: OrderService
  ) {
  }

  ngOnInit() {
    this.itemService.getItemList()
      .then(res => {
        this.itemList = res.body as Item[];
        console.log(res.body)
      })
      .catch(e => console.log("NAZAR: ", e))


    if (this.data.orderItemIndex == null) {
      this.formData = {
        orderItemId: null,
        orderId: this.data.orderId,
        itemId: 0,
        itemName: '',
        price: 0,
        quantity: 0,
        total: 0
      }
    }
    else {
      this.formData = Object.assign({}, this.orderService.orderItems[this.data.orderItemIndex])
    }
  }

  updatePrice(ctrl) {
    if (ctrl.selectedIndex == 0) {
      this.formData.price = 0;
      this.formData.itemName = '';
    }
    else {
      this.formData.price = this.itemList[ctrl.selectedIndex - 1].price;
      this.formData.itemName = this.itemList[ctrl.selectedIndex - 1].name;
    }
    this.updateTotal()
  }

  updateTotal() {
    this.formData.total = parseFloat((this.formData.quantity * this.formData.price).toFixed(2))
  }

  onSubmit(form: NgForm) {
    if (this.validateForm(form.value)) {
      if (this.data.orderItemIndex == null) {
        this.orderService.orderItems.push(form.value)
      }
      else {
        this.orderService.orderItems[this.data.orderItemIndex] = form.value
      }
      this.orderService.offerPrepare().then(res => {
        console.log("OFFER PREPARE: ", res.body);
        if (res.body.length)
          this.orderService.items = res.body as Item[]
      });
      this.dialogRef.close();
    }
  }

  validateForm(formData: OrderItem) {
    this.isValid = true;
    if (formData.itemId == 0) {
      this.isValid = false
    }
    else if (formData.quantity == 0) {
      this.isValid = false
    }
    return this.isValid
  }

}
