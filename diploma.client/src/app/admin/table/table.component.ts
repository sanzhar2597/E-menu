import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";
import {NgForm} from "@angular/forms";
import {Table} from "../../../model/table.model";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  public table: Table[] = [];
  public ngTable?: Table = new Table();
  responseRestaurantTable: any = {};
  public responseObject: any = [
    {
      response: 'empty',
      alertText: 'Успешно добавлено'
    }, {
      response: 'full',
      alertText: 'Успешно обнавлено'
    }
  ];

  public statusTable: Array<any> = [
    {
      value: 0,
      name: 'не доступен'
    },
    {
      value: 1,
      name: 'доступен'
    },

  ];

  constructor(private adminService: AdminService,
              r: ActivatedRoute) {
    adminService.setTitle(r);
  }

  ngOnInit() {
    this.adminService.getTableList().then(value => {
      this.table = value.body;
      this.ngTable = {
        ...this.table[0],
      }
    });
  }


  onSubmit(form: NgForm) {
    if (this.ngTable.name.length) {
      this.adminService.saveRestaurantTable(this.ngTable).then(value => {
          this.ngOnInit()
        for (let key in this.responseObject) {
          if (value.body == this.responseObject[key].response) {
            this.responseRestaurantTable = this.responseObject[key]
          }
        }
        this.removeOpacityClass()
        }
      )
    }
  }

  changeNgTable() {
    let find = this.table.find(value => (value.id == this.ngTable.id));
    if (find) {
      this.ngTable = {
        ...find
      };
      return;
    }
  }

  changeNgTableName() {
  }

  removeOpacityClass() {
    document.getElementById(this.responseRestaurantTable.response).classList.add("response-capacity-to");
    setTimeout(() => {
      document.getElementById(this.responseRestaurantTable.response).classList.remove("response-capacity-to");
    }, 1000)

  }
}
