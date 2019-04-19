import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']
})
export class FoodItemComponent implements OnInit {

  public responseObject: any = [
    {
      response: 'empty',
      alertText: 'Успешно добавлено'
    }, {
      response: 'full',
      alertText: 'Уже Добавлено'
    }
  ];

  public response = {};

  constructor(private adminService: AdminService,
              r: ActivatedRoute
  ) {
    adminService.setTitle(r);
  }

  ngOnInit() {

  }

  removeOpacityClass() {
    setTimeout(
      () => this.response = {}, 2000)
  }

  onSumbit() {
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
