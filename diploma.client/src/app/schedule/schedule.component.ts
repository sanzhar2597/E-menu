import { Component, OnInit } from '@angular/core';
import { LanguagesService } from '../shared/languages.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

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
