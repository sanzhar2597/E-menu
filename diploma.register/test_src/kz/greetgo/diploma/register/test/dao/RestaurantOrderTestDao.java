package kz.greetgo.diploma.register.test.dao;

import kz.greetgo.depinject.core.Bean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface RestaurantOrderTestDao {
	@Insert("insert into item(item_id, name, price) " +
		"values (#{itemId}, #{name}, #{price})")
	void insertItem(@Param("itemId") Integer itemId,
											@Param("name") String name,
											@Param("price") float price);

}
