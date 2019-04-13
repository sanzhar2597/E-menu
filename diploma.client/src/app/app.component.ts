import {Component, OnInit} from '@angular/core';
import {LoginService} from "./login/login.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'diploma';
  li: any;

  constructor(public login: LoginService,
              private currentRoute: ActivatedRoute) {
  }

  async ngOnInit() {
    await this.login.start();
    // document.getElementById("navItem1").classList.add("active")
  }


  /*showMainPage(name: string, id): any {
    this.li = event.currentTarget
    let ids = this.li.id;
    waitTime(ids);

    function waitTime(ids) {
      setTimeout(function () {
        document.getElementById(ids).classList.add("active")
      }, 0)
    }

  }

  addClass() {
    let scope = this;
    for (let i = 0; i < event.currentTarget.children.length; i++) {
      AppComponent.removeActiveClass(event.currentTarget.children[i].id)
    }
  }

  static removeActiveClass(id) {
    document.getElementById(id).classList.remove("active")
  }*/


}
