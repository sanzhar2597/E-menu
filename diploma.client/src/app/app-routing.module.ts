import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {OrdersComponent} from "./orders/orders.component";
import {OrderComponent} from "./orders/order/order.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {BookingComponent} from "./booking/booking.component";
import {AboutComponent} from "./about/about.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  {path: '', redirectTo: 'orders', pathMatch: 'full'},
  {
    path: 'order', children: [
      {path: '', component: OrderComponent},
      {path: 'edit/:id', component: OrderComponent},
      {path: '', component: OrderComponent},
    ]
  },
  {path: 'orders', component: OrdersComponent},
  {path: 'about', component: AboutComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'booking', component: BookingComponent},
  {path: 'admin', loadChildren: "./admin/admin.module#AdminModule",
    canActivate:[AuthGuard]},

  {path: '**', redirectTo: 'order', pathMatch: 'full'},
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
