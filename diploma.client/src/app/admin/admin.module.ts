import {NgModule} from '@angular/core';
import {AdminRoutingModule} from "./admin-routing.module";
import {AdminComponent} from "./admin.component";
import {FoodItemComponent} from "./food-item/food-item.component";
import {MatDialogModule} from "@angular/material/dialog";
import {HttpClientModule} from "@angular/common/http";
import {MatProgressSpinnerModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import { CustomerComponent } from './customer/customer.component';
import { TableComponent } from './table/table.component';
import { MenuDayComponent } from './menu-day/menu-day.component';
import { TitleComponent } from './title/title.component';
import {AdminService} from "./admin.service";
import {CommonModule} from "@angular/common";

@NgModule({
  imports: [
    AdminRoutingModule,
    HttpClientModule, FormsModule, MatDialogModule, MatProgressSpinnerModule,CommonModule
  ],
  declarations: [
    AdminComponent,
    FoodItemComponent,
    CustomerComponent,
    TableComponent,
    MenuDayComponent,
    TitleComponent,
  ],
  exports: [
    AdminComponent,
    FoodItemComponent,
    CustomerComponent,
    TableComponent,
    MenuDayComponent,
    TitleComponent,
  ],
  providers:[
    AdminService
  ]

})
export class AdminModule {
}
