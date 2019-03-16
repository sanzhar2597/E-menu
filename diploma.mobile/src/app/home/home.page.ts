import {Component} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  public homePage: any = [
    {
      component: "app-app-about",
      enable: false
    }
  ]

  changeTab() {
    this.homePage[0].enable = !this.homePage[0].enable
  }
}
