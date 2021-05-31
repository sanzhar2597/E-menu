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
  public imagesUrl;
  ngOnInit() {
    this.imagesUrl = [
      'assets/img/vokzal1.jpg',
      'assets/img/vokzal9.jpg',
      'assets/img/vokzal10.jpg',
      'assets/img/vokzal8.jpg',
      'assets/img/vokzal7.jpg',
      'assets/img/vokzal6.jpg',
      'assets/img/vokzal5.jpg',
    ];

  }




}
