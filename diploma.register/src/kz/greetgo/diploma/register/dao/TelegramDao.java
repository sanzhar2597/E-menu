package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.model.TelegramMenu;
import kz.greetgo.diploma.register.model.PersonLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;

public interface TelegramDao {

	@Select("select * from person where username = #{username} and blocked = 0")
	PersonLogin selectByUsername(@Param("username") String username);

	@Select("SELECT fl.name as foodName,ft.name as foodType, fl.price as price\n" +
		"from food_schedule fs\n" +
		"  inner join food_list fl on fs.food_id = fl.id\n" +
		"  inner join food_type ft on fl.type = ft.id\n" +
		"where fs.data=#{data};")
	ArrayList<TelegramMenu> selectTelegramMenuDay(@Param("data") Date data);


}
