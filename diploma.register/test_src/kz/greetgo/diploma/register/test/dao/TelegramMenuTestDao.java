package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

public interface TelegramMenuTestDao {
	@Insert("insert into food_type(id, name, description) " +
		"values (#{id}, #{name}, #{description})")
	void insertFoodType(@Param("id") String id,
										@Param("name") String name,
										@Param("description") String description
	);
	@Insert("insert into food_list(id, name, type) " +
		"values (#{id}, #{name}, #{type})")
	void insertFoodList(@Param("id") String id,
											@Param("name") String name,
											@Param("type") String type
	);
	@Insert("insert into food_schedule(id, data, food_id) " +
		"values (#{id}, #{data}, #{foodId})")
	void insertFoodSchedule(@Param("id") String id,
											@Param("data") Date data,
											@Param("foodId") String foodId
	);

}
