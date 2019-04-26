import {Component, OnInit} from '@angular/core';
import {OrderService} from "../shared/order.service";
import {NgForm} from "@angular/forms";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {OrderItemsComponent} from "../order-items/order-items.component";
import {CustomerService} from "../shared/customer.service";
import {Customer} from "../../../model/customer.model";
import {ActivatedRoute, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {Order} from "../../../model/order.model";
import {Item} from "../../../model/item.model";
import {BookingService} from "../../shared/booking.service";
import {LanguagesService} from "../../shared/languages.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styles: []
})
export class OrderComponent implements OnInit {

  customerList: Customer[];

  isValid: boolean;

  constructor(public service: OrderService,
              private dialog: MatDialog,
              private customerService: CustomerService,
              private toastr: ToastrService,
              private router: Router,
              private currentRoute: ActivatedRoute,
              private bookingService: BookingService,
              private languagesService: LanguagesService) {
  }

  ngOnInit() {
    this.service.items = [];
    let orderID: string;
    orderID = this.currentRoute.snapshot.paramMap.get('id');
    if (orderID == null) {
      this.resetForm();
      this.checkBooking();
    }
    else {
      this.service.getOrderByID(+orderID).then(res => {
        console.log('orderById: ', res)
        this.service.formData = OrderComponent.formDataAssign(res.body as Order);
        this.service.orderItems = res.body.orderItems;
      });
    }
    this.customerService.getCustomerList()
      .then(res => {
        this.customerList = res.body as Customer[];
        console.log("RES: :", res)
      }).catch(e => console.log(e))

  }

  static formDataAssign(obj: Order): Order {
    let order: Order = new Order();
    order.orderId = obj.orderId;
    order.orderNo = obj.orderNo;
    order.customerId = obj.customerId;
    order.pMethod = obj.pMethod;
    order.gTotal = obj.gTotal;
    order.bookingId = obj.bookingId;
    return order
  }

  resetForm(form?: NgForm) {
    if (form === null)
      form.resetForm();
    this.service.formData = {
      orderId: 0,
      orderNo: Math.floor(100000 + Math.random() * 900000).toString(),
      customerId: 0,
      pMethod: '',
      gTotal: 0,
      bookingId: null
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
    this.service.offerPrepare().then(res => {
      this.service.items = res.body as Item[]
    })
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
    console.log("this.service.formData", this.service.formData);
    if (this.validateForm()) {
      this.service.saveOrUpdateOrder().subscribe(res => {
        this.resetForm();
        this.toastr.success('Submitted Successfully', 'Restaurent App.');
        this.router.navigate(['/orders']);
      })
    }
  }

  checkBooking() {
    if (this.bookingService.booking.bookingId) {
      this.service.formData.bookingId = this.bookingService.booking.bookingId;
    }
  }
}
