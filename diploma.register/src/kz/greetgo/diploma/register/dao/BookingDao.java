package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.register.model.Booking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface BookingDao {

	@Insert("insert into booking(booking_id, number_of_people, record_time, record_date_day, record_date_from, " +
		"record_date_to, table_type, phone_number, customer_id) " +
		"values (#{booking.bookingId}, #{booking.numberOfPeople}, #{booking.recordTime}, #{booking.recordDateDay}, " +
		"#{booking.recordDateFrom}, #{booking.recordDateTo}, #{booking.tableType}, #{booking.phoneNumber}, #{booking.customerId})")
	void insertBooking(@Param("booking") Booking booking);


	@Insert("insert into Person (id, username, surname, name, patronymic, encoded_password, blocked) " +
		"values (#{id}, #{username}, #{surname}, #{name},  #{patronymic},#{encodedPassword}, 0)")
	void checkTime(@Param("booking") Booking booking);
}
