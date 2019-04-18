import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor(private adminService: AdminService,
              r: ActivatedRoute) {
    adminService.setTitle(r);
  }

  ngOnInit() {
  }

}
