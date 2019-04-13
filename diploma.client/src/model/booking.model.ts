import {Table} from "./table.model";
import {Time} from "@angular/common";

export class Booking {
  public bookingId:string;
  public orderId:number;
  public numberOfPeople:number;
  public recordTime:Date= new Date();
  public recordDateDay:string;
  public recordDateFrom:string;
  public recordDateTo:string;
  public tableType:Table;
  public phoneNumber:string;
  public customerId:number|string;
}
