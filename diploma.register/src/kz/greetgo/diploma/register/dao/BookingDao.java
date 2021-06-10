package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.register.model.Booking;
import kz.greetgo.diploma.controller.register.model.Table;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookingDao {

  @Insert(
    "insert into booking(booking_id, number_of_people, number_of_people2, record_time, record_date_day, record_date_from, "
      +
      "record_date_to, table_type, phone_number, person_id, name, surname ) " +
      "values (#{booking.bookingId}, #{booking.numberOfPeople}, #{booking.numberOfPeople2}, #{booking.recordTime}, #{booking.recordDateDay}, "
      +
      "#{booking.recordDateFrom}, #{booking.recordDateTo}, #{booking.tableType}, #{booking.phoneNumber}, #{booking.personId}, #{booking.name}, #{booking.surname})")
  void insertBooking(@Param("booking") Booking booking);


  @Select("select booking_id as bookingId, number_of_people as numberOfPeople, record_time as recordTime, " +
    "record_date_day as recordDateDay, record_date_from as recordDateFrom, record_date_to as recordDateTo, " +
    "table_type as tableType, phone_number as phoneNumber, person_id as personId from booking " +
    "where table_type = #{booking.tableType} and record_date_day= #{booking.recordDateDay} and "
    + "number_of_people = #{booking.numberOfPeople} and number_of_people2 = #{booking.numberOfPeople2} ")
  List<Booking> checkTime(@Param("booking") Booking booking);


  @Select("select booking_id as bookingId, number_of_people as numberOfPeople, record_time as recordTime, " +
    "record_date_day as recordDateDay, record_date_from as recordDateFrom, record_date_to as recordDateTo, " +
    "table_type as tableType, phone_number as phoneNumber, person_id as personId from booking " +
    "where  person_id= #{id}")
  List<Booking> getBookingById(@Param("id") String id);

  @Select("select booking_id as bookingId, number_of_people as numberOfPeople, record_time as recordTime, " +
    "record_date_day as recordDateDay, record_date_from as recordDateFrom, record_date_to as recordDateTo, " +
    "table_type as tableType, phone_number as phoneNumber, person_id as personId from booking ")
  List<Booking> getBookings();


  @Select("select name from restaurant_table where status = 1")
  List<String> selectRestaurantTable();

  @Select("select *from restaurant_table where status = 1")
  List<Table> getRestaurantTableList();

  @Insert("insert into Person (id, username, encoded_password, blocked) " +
    "values (#{id}, #{username}, #{encodedPassword}, 0)")
  void insertPerson(@Param("id") String id,
                    @Param("username") String username,
                    @Param("encodedPassword") String encodedPassword
  );

  @Select("select id from Person where id = #{id}")
  String selectPersonID(@Param("id") String id);

  @Select("select id from Person where username = #{username}")
  String getPersonId(@Param("username") String username);

}
