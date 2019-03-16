import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { MainPage } from './main.page';
import {MainRoutingModule} from "./main-routing.module";



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MainRoutingModule
  ],
  declarations: [MainPage]
})
export class MainPageModule {}



