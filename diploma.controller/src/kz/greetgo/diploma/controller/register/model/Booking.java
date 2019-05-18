package kz.greetgo.diploma.controller.register.model;

import java.util.Date;

public class Booking {
	public Integer  bookingId;
	public Integer numberOfPeople;
	public Date recordTime;
	public String recordDateDay;
	public String recordDateFrom;
	public String recordDateTo;
	public String tableType;
	public String phoneNumber;
	public String personId;

	@Override
	public String toString() {

		return "Booking{" +
			"bookingId=" + bookingId +
			", numberOfPeople=" + numberOfPeople +
			", recordTime=" + recordTime +
			", recordDateDay='" + recordDateDay + '\'' +
			", recordDateFrom='" + recordDateFrom + '\'' +
			", recordDateTo='" + recordDateTo + '\'' +
			", tableType=" + tableType +
			", phoneNumber='" + phoneNumber + '\'' +
			", personId=" + personId +
			'}';
	}
}

