import {Injectable} from '@angular/core';
import {HttpService} from "../http.service";
import {Booking} from "../../model/booking.model";
import {Table} from "../../model/table.model";

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  public booking: Booking = new Booking();
  public table: Table[] = [Table.CENTER, Table.RIGHT,Table.LEFT, Table.HALL];
  public processResponse = "";
  constructor(private httpService: HttpService) {
  }


  checkTime() {
    let booking = this.booking;
  return this.httpService.get('/booking/check-time', {booking: JSON.stringify(booking)}).toPromise();
  }

  saveBooking() {
    let booking = this.booking;
    return this.httpService.get('/booking/save', {booking: JSON.stringify(booking)}).toPromise();
  }

}
