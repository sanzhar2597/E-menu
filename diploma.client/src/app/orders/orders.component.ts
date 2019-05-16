import {Component, OnInit} from '@angular/core';
import {OrderService} from "./shared/order.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {LanguagesService} from "../shared/languages.service";
import {LoginService} from "../login/login.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orderList;

  constructor(private service: OrderService,
              private router: Router,
              private toastr: ToastrService,
              public languagesService: LanguagesService,
              public loginService: LoginService) {
  }

  ngOnInit() {
    this.refreshList();
  }

  refreshList() {
    this.service.getOrderList().then(res => {
      console.log("RES::::", res)


      this.orderList = res.body
    });
  }

  changeStatusAccept(item: any) {

    item.status = 2;
    this.service.updateOrderStatus(item).then(value => {
      this.refreshList()
    })

  }

  changeStatusComplete(item: any) {

    item.status = 3;
    this.service.updateOrderStatus(item).then(value => {
      this.refreshList()
    })
  }

  openForEdit(item:any) {

    if (item.status > 1) {
      return
    }

    if (this.loginService.canViewWaiter) {
      return
    }

    this.router.navigate(['/order/edit/' + item.orderId]);
  }

  onOrderDelete(id: number) {
    if (confirm('Are you sure to delete this record?')) {
      this.service.deleteOrder(id).then(res => {
        this.refreshList();
        this.toastr.warning("Deleted Successfully", "Restaurent App.");
      });
    }
  }

}
