import {Component, OnInit} from '@angular/core';
import {LoginService} from "../login/login.service";
import {LanguagesService} from "../shared/languages.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title = this.languagesService.languages.diploma;

  constructor(public login: LoginService,
              public languagesService: LanguagesService) {
  }

  ngOnInit() {
  }

}
