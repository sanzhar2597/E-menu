import {Component, OnInit} from '@angular/core';
import {OrderService} from "../shared/order.service";
import {NgForm} from "@angular/forms";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {OrderItemsComponent} from "../order-items/order-items.component";
import {CustomerService} from "../shared/customer.service";
import {Customer} from "../../../model/customer.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styles: []
})
export class OrderComponent implements OnInit {

  customerList: Customer[];

  isValid: boolean;

  constructor(private service: OrderService,
              private dialog: MatDialog,
              private customerService: CustomerService,
              private toastr: ToastrService,
              private router: Router,
              private currentRoute: ActivatedRoute) {
  }

  ngOnInit() {
    let orderID: string;
    orderID = this.currentRoute.snapshot.paramMap.get('id');
    if (orderID == null)
      this.resetForm()
    else{
      this.service.getOrderByID(+orderID)
    }
    this.customerService.getCustomerList()
      .then(res => {
        this.customerList = res.body as Customer[];
        console.log("RES: :", res)
      }).catch(e => console.log(e))

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
    this.dialog.open(OrderItemsComponent, dialogConfig).afterClosed().subscribe(res => {
      this.updateGrandTotal()
    })
  }

  onDeleteOrderItem(orderItemId: number, i: number) {
    event.preventDefault();
    this.service.orderItems.splice(i, 1)
    this.updateGrandTotal();
  }

  updateGrandTotal() {
    this.service.formData.gTotal = this.service.orderItems.reduce((previousValue, currentValue) => {
      return previousValue + currentValue.total
    }, 0)
    this.service.formData.gTotal = parseFloat((this.service.formData.gTotal).toFixed(2))
  }

  validateForm() {
    this.isValid = true;
    if (this.service.formData.customerId == 0) {
      this.isValid = false;
    }
    else if (this.service.orderItems.length == 0) {
      this.isValid = false;
    }
    return this.isValid
  }

  onSubmit(form: NgForm) {
    if (this.validateForm()) {
      this.service.saveOrUpdateOrder().subscribe(res => {
        this.service.saveOrUpdateOrder2().subscribe(res => {
          this.resetForm();
          this.toastr.success('Submitted Successfully', 'Restaurent App.');
          this.router.navigate(['/orders']);
        })
      })
    }
  }
}
