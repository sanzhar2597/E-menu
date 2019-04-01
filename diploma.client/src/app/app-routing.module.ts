import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {OrdersComponent} from "./orders/orders.component";
import {OrderComponent} from "./orders/order/order.component";
import {HeaderComponent} from "./header/header.component";

const routes: Routes = [
  {path: '', redirectTo: 'order', pathMatch: 'full'},
  {path: 'orders', component: OrdersComponent},
  {path: 'header', component: HeaderComponent},
  {
    path: 'order', children: [
      {path: '', component: OrderComponent},
      {path: 'edit/:id', component: OrderComponent},
      {path: '', component: OrderComponent},
    ]
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}


/*
const routes:Routes = [
  // {path:'',redirectTo:'order',pathMatch:'full'},
  {path:'orders',component:OrdersComponent},

]*/
