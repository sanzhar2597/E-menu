import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import { ToastrModule } from 'ngx-toastr';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {HttpService} from "./http.service";
import {HttpClientModule} from "@angular/common/http";
import {LoginService} from "./login/login.service";
import {FormsModule} from "@angular/forms";
import {ClientListComponent} from './client-list/client-list.component';
import {ClientListService} from "./client-list/client-list.service";
import { AboutComponent } from './about/about.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderComponent } from './orders/order/order.component';
import { OrderItemsComponent } from './orders/order-items/order-items.component';
import { AppRoutingModule } from './/app-routing.module';
import {OrderService} from "./orders/shared/order.service";
import { HeaderComponent } from './header/header.component';
import { RegistrationComponent } from './registration/registration.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ClientListComponent,
    AboutComponent,
    OrdersComponent,
    OrderComponent,
    OrderItemsComponent,
    HeaderComponent,
    RegistrationComponent,
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, AppRoutingModule,
    BrowserAnimationsModule, MatDialogModule,  ToastrModule.forRoot()
  ],
  entryComponents:[OrderItemsComponent],
  providers: [HttpService, LoginService, ClientListService, OrderService],
  bootstrap: [AppComponent]
})
export class AppModule {}
