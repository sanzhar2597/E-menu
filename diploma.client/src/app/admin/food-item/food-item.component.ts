import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, UrlSegment} from "@angular/router";

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

  constructor(r: ActivatedRoute) {
    r.url.subscribe((s: UrlSegment[]) => {
      debugger
      console.log("url", s);
    });
  }

  ngOnInit() {
  }

}
