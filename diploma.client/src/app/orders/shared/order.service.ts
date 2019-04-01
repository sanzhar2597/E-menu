import {Injectable} from '@angular/core';
import {Order} from "../../../model/order.model";
import {OrderItem} from "../../../model/orderItem.model";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  formData: Order
  orderItems: OrderItem[];

  constructor() {
  }
}
