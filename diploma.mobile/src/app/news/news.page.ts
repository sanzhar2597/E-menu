import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-news',
  templateUrl: './news.page.html',
  styleUrls: ['./news.page.scss'],
})
export class NewsPage implements OnInit {
  id:number = 5;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToNew(){
    this.router.navigate(["/news",this.id])
  }

}
