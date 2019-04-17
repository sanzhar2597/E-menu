import {Injectable} from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  public title: string;

  constructor(public router:Router) {
  }

  changeTitle() {
    this.title = "lalala"
  }

}
