import {Injectable} from '@angular/core';
import {Order} from "../../../model/order.model";
import {OrderItem} from "../../../model/orderItem.model";
import {HttpService} from "../../http.service";
import {Item} from "../../../model/item.model";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  public formData: Order;
  public orderItems: OrderItem[];
  public items: Item[] = [new Item()];

  constructor(private httpService: HttpService) {
  }

  saveOrUpdateOrder() {

    let orderItems = {
      ...this.formData,
      orderItems: this.orderItems
    };

    return this.httpService.post('/restaurant' + '/order-items', {orderItems: JSON.stringify(orderItems)})
  }

  getOrderList() {

    return this.httpService.get('/restaurant/get-orders').toPromise();
  }

  getOrderByID(id: number): any {
    return this.httpService.get('/restaurant/get-order', {id}).toPromise();
  }

  deleteOrder(id: number) {
    return this.httpService.get('/restaurant/delete-order', {id}).toPromise();
  }

  offerPrepare() {
    return this.httpService.get('/restaurant/offer', {orderItems: JSON.stringify(this.orderItems)}).toPromise();
  }

}
