import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin.component";
import {FoodItemComponent} from "./food-item/food-item.component";
import {CustomerComponent} from "./customer/customer.component";
import {TableComponent} from "./table/table.component";
import {MenuDayComponent} from "./menu-day/menu-day.component";
import {Languages} from "../shared/languages";
import {LanguagesService} from "../shared/languages.service";


const languagesServices = new Languages();
const routes: Routes = [
  {
    path: '',            //<---- parent component declared here
    component: AdminComponent,
    children: [                          //<---- child components declared here
      {
        path: languagesServices.RU_LANGUAGE.urlfooditem,
        component: FoodItemComponent
      },
      {
        path: languagesServices.RU_LANGUAGE.urlcustomer,
        component: CustomerComponent
      },
      {
        path: languagesServices.RU_LANGUAGE.urltable,
        component: TableComponent
      },
      {
        path: languagesServices.RU_LANGUAGE.urlmenuday,
        component: MenuDayComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {
}
