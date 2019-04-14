package kz.greetgo.diploma.controller.register;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.diploma.controller.register.model.Booking;

import java.text.ParseException;

public interface BookingRegister {

	String checkTime(Booking booking);

	void insertBooking(Booking booking) throws ParseException;
}
