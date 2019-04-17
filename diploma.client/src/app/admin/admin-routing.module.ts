import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminComponent} from "./admin.component";
import {FoodItemComponent} from "./food-item/food-item.component";
import {CustomerComponent} from "./customer/customer.component";
import {TableComponent} from "./table/table.component";
import {MenuDayComponent} from "./menu-day/menu-day.component";

const routes: Routes = [
  {
    path: '',            //<---- parent component declared here
    component: AdminComponent,
    children: [                          //<---- child components declared here
      {
        path:'food-item',
        component: FoodItemComponent
      },
      {
        path:'customer',
        component: CustomerComponent
      },
      {
        path:'table',
        component: TableComponent
      },
      {
        path:'menu-day',
        component: MenuDayComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
