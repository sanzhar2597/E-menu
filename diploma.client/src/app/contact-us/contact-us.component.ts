import { Component, OnInit } from '@angular/core';
import {LanguagesService} from "../shared/languages.service";

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css',
  '../../style/style.css']
})
export class ContactUsComponent implements OnInit {

  constructor(public languagesService: LanguagesService) { }

  ngOnInit() {
  }

}
