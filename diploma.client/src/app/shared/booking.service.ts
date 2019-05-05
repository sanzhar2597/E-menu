import {Injectable} from '@angular/core';
import {HttpService} from "../http.service";
import {Booking} from "../../model/booking.model";

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  public booking: Booking = new Booking();
  public table: Array<string> = [];
  public processResponse = "";

  constructor(private httpService: HttpService) {
    this.getRestaurantTable().then(value => {
        this.table = value.body
      }
    )
  }


  checkTime() {
    let booking = this.booking;
    return this.httpService.get('/booking/check-time', {booking: JSON.stringify(booking)}).toPromise();
  }

  saveBooking() {
    let booking = this.booking;
    return this.httpService.get('/booking/save', {booking: JSON.stringify(booking)}).toPromise();
  }

  getRestaurantTable() {
    return this.httpService.get('/booking/restaurant-table').toPromise();

  }

}
