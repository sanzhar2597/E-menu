package kz.greetgo.diploma.controller.register.model;

import java.util.Date;

public class Booking {

	public Integer bookingId;

	public String numberOfPeople;

	public String numberOfPeople2;

	public Date recordTime;

	public String recordDateDay;

	public String recordDateFrom;

	public String recordDateTo;

	public String tableType;

	public String phoneNumber;

	public String personId;

	public String name;

	public String surname;

	@Override
	public String toString() {

		return "Booking{" +
			"bookingId=" + bookingId +
			", numberOfPeople=" + numberOfPeople +
			", numberOfPeople2=" + numberOfPeople2 +
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

