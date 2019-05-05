import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AdminService} from "../admin.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  public ngModelSelect:any[] =[];
  public ngID:number;
  constructor(private adminService: AdminService,
              r: ActivatedRoute) {
    adminService.setTitle(r);
  }

  ngOnInit() {
  }
  changeModel(){
    for (let key in this.ngModelSelect){
      if(this.ngModelSelect[key] == this.ngID){
        this.ngModelSelect.splice(+key, 1)
        return
      }
    }
    this.ngModelSelect.push(this.ngID)
  }

}
