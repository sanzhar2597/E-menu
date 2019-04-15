package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.register.model.Booking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookingDao {

	@Insert("insert into booking(booking_id, number_of_people, record_time, record_date_day, record_date_from, " +
		"record_date_to, table_type, phone_number, customer_id) " +
		"values (#{booking.bookingId}, #{booking.numberOfPeople}, #{booking.recordTime}, #{booking.recordDateDay}, " +
		"#{booking.recordDateFrom}, #{booking.recordDateTo}, #{booking.tableType}, #{booking.phoneNumber}, #{booking.customerId})")
	void insertBooking(@Param("booking") Booking booking);


	@Select("select booking_id as bookingId, number_of_people as numberOfPeople, record_time as recordTime, " +
		"record_date_day as recordDateDay, record_date_from as recordDateFrom, record_date_to as recordDateTo, " +
		"table_type as tableType, phone_number as phoneNumber, customer_id as customerId from booking " +
		"where table_type = #{booking.tableType} and record_date_day= #{booking.recordDateDay}")
	List<Booking> checkTime(@Param("booking") Booking booking);
}
