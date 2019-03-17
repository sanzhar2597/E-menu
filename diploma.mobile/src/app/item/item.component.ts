import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
})
export class ItemComponent implements OnInit {

  private id:number;
  private product :string;
  private price :string;
  private routeSubscription: Subscription;
  private querySubscription: Subscription;
  constructor(private activeRoute: ActivatedRoute) {
    this.routeSubscription = activeRoute.params.subscribe(params => this.id = params['id'])
    this.querySubscription = activeRoute.queryParams.subscribe(
      (queryParam:any)  => {
      this.product = queryParam['product'];
      this.price = queryParam['price'];
    }
    );
  }

  ngOnInit() {}

}
