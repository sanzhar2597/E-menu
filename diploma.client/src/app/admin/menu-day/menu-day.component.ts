import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";
import {NgForm} from "@angular/forms";
import {FoodType} from "../../../model/food-type.model";
import {FoodList} from "../../../model/food-list.model";
import {FoodSchedule} from "../../../model/food-schedule.model";
import {LanguagesService} from "../../shared/languages.service";

@Component({
  selector: 'app-menu-day',
  templateUrl: './menu-day.component.html',
  styleUrls: ['./menu-day.component.css']
})
export class MenuDayComponent implements OnInit {


  public foodType: FoodType[] = [];
  public foodList: FoodList[] = [];
  public foodSchedule: FoodSchedule = new FoodSchedule();
  public dateMenu: Date = new Date();
  foodTypeNgModel: number;
  foodListNgModel: number;
  disableFoodList: boolean = true;
  responseFoodSchedule: any = {};
  public responseObject: any = [
    {
      response: this.languagesService.languages.empty,
      alertText: this.languagesService.languages.successadded
    }, {
      response: this.languagesService.languages.full,
      alertText: this.languagesService.languages.alreadyadded
    }
  ];

  constructor(private adminService: AdminService,
              r: ActivatedRoute,
              public languagesService: LanguagesService) {
    adminService.setTitle(r);
  }

  ngOnInit() {
    this.foodType = [];
    this.foodList = [];
    this.foodSchedule.id = Math.floor(100000 + Math.random() * 900000).toString();
    this.adminService.getFoodItem().then(value => {
      this.foodType = value.body
      this.callFoodList()

    })
  }

  onSumbit(form: NgForm) {
    event.preventDefault();
    this.saveFoodSchedule()

  }

  saveFoodSchedule() {
    if (this.foodSchedule.data && this.foodSchedule.id) {
      debugger
      this.adminService.saveMenuDay(this.foodSchedule).then(value => {
        this.foodSchedule.id = Math.floor(100000 + Math.random() * 900000).toString();
        for (let key in this.responseObject) {
          if (value.body == this.responseObject[key].response) {
            this.responseFoodSchedule = this.responseObject[key]
          }
        }
        this.removeOpacityClass()
      })
    }
  }


  gotoDatabse() {
    this.disableFoodList = true;
    setTimeout(() => {
      this.adminService.getFoodList(this.foodTypeNgModel).then(value => {
        this.disableFoodList = false;
        this.foodList = value.body
      })
    }, 0)

  }

  callFoodList() {
    this.disableFoodList = true;
    setTimeout(() => {
      this.adminService.getFoodList(this.foodType[0].id).then(value => {
        this.disableFoodList = false;
        this.foodList = value.body
      })
    }, 0)

  }

  changeDate() {
    this.foodSchedule.data = this.dateMenu;
  }

  changeFoodList() {
    this.foodSchedule.foodId = this.foodListNgModel
  }


  removeOpacityClass() {
    document.getElementById(this.responseFoodSchedule.response).classList.add("response-capacity-to");
    setTimeout(() => {
      document.getElementById(this.responseFoodSchedule.response).classList.remove("response-capacity-to");
    }, 1000)

  }
}
