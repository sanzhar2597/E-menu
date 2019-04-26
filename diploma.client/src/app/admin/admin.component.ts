import {Component, OnInit} from '@angular/core';
import {AdminService} from "./admin.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(public adminService: AdminService, private r: ActivatedRoute,
  ) {
  }


  ngOnInit() {
    this.adminService.setTitle(this.r);
  }

}
