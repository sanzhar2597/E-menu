import {Component, OnInit} from '@angular/core';
import {AdminService} from "../admin.service";

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
    console.log("this.adminService.title", this.adminService.title);
  }
}
