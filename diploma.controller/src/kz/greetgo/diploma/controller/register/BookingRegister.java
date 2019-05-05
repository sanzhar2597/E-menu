package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.register.model.Booking;

import java.text.ParseException;
import java.util.List;

public interface BookingRegister {

	String checkTime(Booking booking);

	void insertBooking(Booking booking) throws ParseException;

	List<String> getRestaurantTable();


}
