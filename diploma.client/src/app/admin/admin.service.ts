import {Injectable} from '@angular/core';
import {ActivatedRoute, UrlSegment} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  public title: string;

  public adminChildUrl = [
    {
      url: "food-item",
      title: "Add Product"
    },
    {
      url: "customer",
      title: "Add Customer"
    },
    {
      url: "table",
      title: "Add Table"
    },
    {
      url: "menu-day",
      title: "Add Menu-day"
    },
  ];


  constructor() {
  }

  changeTitle(url: string) {
    for (let key in this.adminChildUrl) {
      if (this.adminChildUrl[key].url == url) {
        this.title = this.adminChildUrl[key].title;
      }
    }
  }

  setTitle(r: ActivatedRoute) {
    r.url.subscribe((s: UrlSegment[]) => {
      this.changeTitle(s[0].path)
    });
  }

}
