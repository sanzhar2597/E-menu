import {Component, OnInit} from '@angular/core';
import {LanguagesService} from "../shared/languages.service";
import {map} from "rxjs/operators";
import {fromEvent} from "rxjs";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css',
    '../../style/style.css']
})
export class AboutComponent implements OnInit {

  constructor(public languagesService: LanguagesService) {
  }

  ngOnInit() {


  }




}
