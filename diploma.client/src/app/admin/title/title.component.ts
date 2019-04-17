import { Component, OnInit } from '@angular/core';
import {AdminService} from "../admin.service";
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-title',
  templateUrl: './title.component.html',
  styleUrls: ['./title.component.css']
})
export class TitleComponent implements OnInit {

  private legacy;

  constructor(private adminService: AdminService,) {
  }

  ngOnInit() {
    this.adminService.changeTitle()
    console.log("this.adminService.title", this.adminService.title);

  }
}
