import {Component, OnInit} from '@angular/core';
import {LoginService} from "./login/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'diploma';

  constructor(public login: LoginService,
              ) {}

 async ngOnInit(){
    await this.login.start();
  }

  showMainPage(name:string){
    console.log(this.login)
  }



}
