import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
ItemComponent
import { ListPage } from './list.page';
import {ItemComponent} from "../item/item.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild([
      {
        path: '',
        component: ListPage
      },
      {
        path: 'item/:id',
        component: ItemComponent
      }
    ])
  ],
  declarations: [ListPage, ItemComponent]
})
export class ListPageModule {}
