package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.register.model.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminDao {

	@Insert("insert into item(name, price) " +
		"values (#{item.name}, #{item.price})")
	void insertItem(@Param("item") Item item);

	@Select("select item_id as itemId, name as name, price as price from item where name = #{item.name}")
	List<Item> checkItem(@Param("item") Item item);
}
