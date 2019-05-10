import {Injectable, OnDestroy} from '@angular/core';
import {ActivatedRoute, UrlSegment} from "@angular/router";
import {Item} from "../../model/item.model";
import {HttpService} from "../http.service";
import {FoodSchedule} from "../../model/food-schedule.model";
import {Table} from "../../model/table.model";
import {PersonDisplays} from "../../model/PersonDisplays";
import {LanguagesService} from "../shared/languages.service";
import {Subscription} from "rxjs/Subscription";

@Injectable({
  providedIn: 'root'
})
export class AdminService implements OnDestroy {

  public title: string;


  public adminChildUrl = [
    {
      url: "",
      title: this.languagesService.languages.admin.toFirstTitleCase()
    },
    {
      url: this.languagesService.languages.urlfooditem,
      title: this.languagesService.languages.productadd.toFirstTitleCase()
    },
    {
      url: this.languagesService.languages.urlcustomer,
      title: this.languagesService.languages.customeraddrole.toFirstTitleCase()
    },
    {
      url: this.languagesService.languages.urltable,
      title: this.languagesService.languages.tableedit.toFirstTitleCase()
    },
    {
      url: this.languagesService.languages.urlmenuday,
      title: this.languagesService.languages.menudayadd.toFirstTitleCase()
    },

  ];
  public item: Item = new Item;
  private subscription: Subscription;


  constructor(private httpService: HttpService,
              public languagesService: LanguagesService,
  ) {

    this.subscription = this.languagesService.languageChanged.asObservable().subscribe(() => {

      this.hotReload();

    });

  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }


  hotReload() {
    this.adminChildUrl = [
      {
        url: "",
        title: this.languagesService.languages.admin.toFirstTitleCase()
      },
      {
        url: this.languagesService.languages.urlfooditem,
        title: this.languagesService.languages.productadd.toFirstTitleCase()
      },
      {
        url: this.languagesService.languages.urlcustomer,
        title: this.languagesService.languages.customeraddrole.toFirstTitleCase()
      },
      {
        url: this.languagesService.languages.urltable,
        title: this.languagesService.languages.tableedit.toFirstTitleCase()
      },
      {
        url: this.languagesService.languages.urlmenuday,
        title: this.languagesService.languages.menudayadd.toFirstTitleCase()
      },

    ];

    this.changeTitle("");
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

  saveRestaurantTable(table: Table) {
    return this.httpService.get('/admin/save-restaurant-table', {table: JSON.stringify(table)}).toPromise();

  }

  getFoodItem() {
    return this.httpService.get('/admin/get-food-type',).toPromise();
  }

  getFoodList(id) {
    return this.httpService.get('/admin/get-food-list', {id}).toPromise();
  }

  getTableList() {
    return this.httpService.get('/admin/get-table-list').toPromise();
  }

  getPersonDisplayList() {
    return this.httpService.get('/admin/get-person-display-list').toPromise();
  }

  getUserCanList() {
    return this.httpService.get('/admin/get-user-cans-list').toPromise();
  }

  updatePersonCan(personDisplay: PersonDisplays) {
    return this.httpService.get('/admin/update-person-can', {personDisplay: JSON.stringify(personDisplay)}).toPromise();
  }


}
