package kz.greetgo.diploma.register.dao;

import javafx.scene.control.Tab;
import kz.greetgo.diploma.controller.register.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao {

	@Insert("insert into item(name, price) " +
		"values (#{item.name}, #{item.price})")
	void insertItem(@Param("item") Item item);

	@Select("select item_id as itemId, name as name, price as price from item where name = #{item.name}")
	List<Item> checkItem(@Param("item") Item item);

	@Insert("insert into food_schedule(id, data, food_id) " +
		"values (#{foodSchedule.id}, #{foodSchedule.data}, #{foodSchedule.foodId})")
	void insertFoodSchedule(@Param("foodSchedule") FoodSchedule foodSchedule);

	@Select("select id, data , food_id as foodId from food_schedule where food_id = #{foodSchedule.foodId}||'' and data = #{foodSchedule.data}")
	List<FoodSchedule> checkFoodSchedule(@Param("foodSchedule") FoodSchedule foodSchedule);

	@Select("select * from food_type")
	List<FoodType> selectFoodItem();

	@Select("select * from food_list where type::integer = #{id}")
	List<FoodList> selectFoodList(Integer id);

	@Select("select * from restaurant_table")
	List<Table> getTableList();


	@Select("select * from restaurant_table where id= #{table.id} and  name =#{table.name}")
	List<Table> selectRestaurantTable(@Param("table") Table table);

	@Insert("insert into restaurant_table(name, status) " +
		"values (#{table.name}, #{table.status})")
	void insertRestaurantTable(@Param("table") Table table);

	@Update("update restaurant_table set status = #{table.status} where id = #{table.id} and name = #{table.name}")
	void updateRestaurantTable(@Param("table") Table table);
}
