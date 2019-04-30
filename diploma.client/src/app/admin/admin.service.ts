import {Injectable} from '@angular/core';
import {ActivatedRoute, UrlSegment} from "@angular/router";
import {Item} from "../../model/item.model";
import {HttpService} from "../http.service";
import {FoodSchedule} from "../../model/food-schedule.model";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  public title: string;

  public adminChildUrl = [
    {
      url: "",
      title: "Admin"
    },
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
  public item: Item = new Item;


  constructor(private httpService: HttpService) {
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
      if (s.length) {
        this.changeTitle(s[0].path)
      }
      else {
        this.changeTitle("");
      }
    });
  }

  saveProduct() {
    return this.httpService.get('/admin/save-product', {item: JSON.stringify(this.item)}).toPromise();
  }

  saveMenuDay(foodSchedule: FoodSchedule) {

    return this.httpService.get('/admin/save-menu-day', {foodSchedule: JSON.stringify(foodSchedule)}).toPromise();
  }

  getFoodItem() {
    return this.httpService.get('/admin/get-food-type',).toPromise();
  }

  getFoodList(id) {
    return this.httpService.get('/admin/get-food-list', {id}).toPromise();
  }

}
