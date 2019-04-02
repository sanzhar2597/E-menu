import {Injectable} from '@angular/core';
import {HttpService} from "../../http.service";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpService: HttpService) {
  }

  getCustomerList() {
    return this.httpService.get('/restaurant/customer').toPromise();
  }
}
