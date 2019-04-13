package kz.greetgo.diploma.controller.register.model;

import java.util.Date;

public class Booking {
	public Integer bookingId;
	public Integer orderId;
	public Integer numberOfPeople;
	public Date recordTime;
	public Date recordDateFrom;
	public Date recordDateTo;
	public Enum<Table> tableType;
	public Integer phoneNumber;
	public Integer customerId;

	@Override
	public String toString() {

		return "Booking{" +
			"bookingId=" + bookingId +
			", orderId=" + orderId +
			", numberOfPeople=" + numberOfPeople +
			", recordTime=" + recordTime +
			", recordDateFrom=" + recordDateFrom +
			", recordDateTo=" + recordDateTo +
			", tableType=" + tableType +
			", phoneNumber=" + phoneNumber +
			", customerId=" + customerId +
			'}';
	}
}

