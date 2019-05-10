import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";
import {NgForm} from "@angular/forms";
import {LanguagesService} from "../../shared/languages.service";

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

  public responseObject: any = [
    {
      response: this.languagesService.languages.empty,
      alertText: this.languagesService.languages.successadded
    }, {
      response: this.languagesService.languages.full,
      alertText: this.languagesService.languages.alreadyadded
    }
  ];

  public response: any = {};

  constructor(public adminService: AdminService,
              r: ActivatedRoute,
              public languagesService: LanguagesService
  ) {
    adminService.setTitle(r);
  }

  ngOnInit() {

  }

  removeOpacityClass() {
    setTimeout(
      () => this.response = {}, 2000)
  }

  onSumbit(form: NgForm) {
    event.preventDefault();
    console.log("this.adminService.item", this.adminService.item);
    this.adminService.saveProduct().then(
      res => {
        for (let key in this.responseObject) {
          if (res.body == this.responseObject[key].response) {
            this.response = this.responseObject[key]
          }
        }
        this.removeOpacityClass()
      }
    );
  }


}
