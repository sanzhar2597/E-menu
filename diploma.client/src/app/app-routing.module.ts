import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {OrdersComponent} from "./orders/orders.component";
import {OrderComponent} from "./orders/order/order.component";
import {HeaderComponent} from "./header/header.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {BookingComponent} from "./booking/booking.component";
import {AdminComponent} from "./admin/admin.component";

const routes: Routes = [
  {path: '', redirectTo: 'order', pathMatch: 'full'},
  {
    path: 'order', children: [
      {path: '', component: OrderComponent},
      {path: 'edit/:id', component: OrderComponent},
      {path: '', component: OrderComponent},
    ]
  },
  {path: 'orders', component: OrdersComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'booking', component: BookingComponent},
  {path: 'admin', component: AdminComponent},

];

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
