import {Injectable} from '@angular/core';
import {Order} from "../../../model/order.model";
import {OrderItem} from "../../../model/orderItem.model";
import {HttpService} from "../../http.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  formData: Order;
  orderItems: OrderItem[];

  constructor(private httpService: HttpService) {
  }


  saveOrUpdateOrder() {

    let orderItems= {
        ...this.formData,
      orderItems: this.orderItems
    };
    return this.httpService.post('/restaurant'+ '/order-items',{orderItems:JSON.stringify(orderItems)})
    // return this.httpService.post('/restaurant'+ '/set-order',body)
  }


  saveOrUpdateOrder2(){
    let body = {
      Order: this.formData,
      OrderItems: this.orderItems
    };
    return this.httpService.post('/restaurant'+ '/order-item',{orderItems: JSON.stringify(this.orderItems)})
  }


  getOrderList() {

    return this.httpService.get('/restaurant/get-orders').toPromise();
  }

  getOrderByID(id:number):any {
    return this.httpService.get('/restaurant/get-order/',{id}).toPromise();
  }

  deleteOrder(id:number) {
    return this.httpService.delete('/restaurant/delete-order/'+id).toPromise();
  }

}
