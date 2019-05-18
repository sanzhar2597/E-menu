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
  todayTime;

  constructor(private service: OrderService,
              private router: Router,
              private toastr: ToastrService,
              public languagesService: LanguagesService,
              public loginService: LoginService) {
  }

  ngOnInit() {
    this.refreshList();
    this.todayTime = this.formatDate(new Date())
  }

  refreshList() {
    this.service.getOrderList().then(res => {
      console.log("RES::::", res)


      this.orderList = res.body
      this.showDate()
      this.sortByKey(this.orderList, "orderNo")

    });
  }

  sortByKey(array, key) {
    return array.sort(function (a, b) {
      var x = a[key];
      var y = b[key];
      return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
  }

  showDate() {
    for (let key in this.orderList) {
      if (!this.orderList[key].recordDateDay) {
        this.orderList[key].recordDateDay = "online"
        continue
      }
      this.orderList[key].recordDateDay = this.formatDate(new Date(this.orderList[key].recordDateDay))
    }
  }

  formatDate(date) {
    var monthNames = [
      "January", "February", "March",
      "April", "May", "June", "July",
      "August", "September", "October",
      "November", "December"
    ];

    var day = date.getDate();
    var monthIndex = date.getMonth();
    var year = date.getFullYear();

    return day + ' ' + monthNames[monthIndex] + ' ' + year;
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

  openForEdit(item: any) {

    if (item.status > 1 || this.loginService.canViewWaiter) {
      this.router.navigate(['/order-view/edit/' + item.orderId]);
      return
    }

    /*if (this.loginService.canViewWaiter) {
      return
    }*/


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
