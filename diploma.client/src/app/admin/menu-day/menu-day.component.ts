import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-menu-day',
  templateUrl: './menu-day.component.html',
  styleUrls: ['./menu-day.component.css']
})
export class MenuDayComponent implements OnInit {

  constructor(private adminService: AdminService,
              r: ActivatedRoute) {
    adminService.setTitle(r);
  }

  ngOnInit() {
  }

  onSumbit(form: NgForm) {
    event.preventDefault();
  }

}
