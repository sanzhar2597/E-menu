import { Component, OnInit } from '@angular/core';
import {Item} from "../model/item";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order',
  templateUrl: './order.page.html',
  styleUrls: ['./order.page.scss'],
})
export class OrderPage implements OnInit {

item:Item = new Item()
  constructor(private router:Router) { }

  ngOnInit() {
  }
  openItem(myItem:Item){
this.router.navigate(['/list/item', myItem.id],{
  queryParams:{
    product:myItem.product,
    price:myItem.price
  }

})
  }

}
