package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.register.model.PersonLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TelegramDao {

	@Select("select * from person where username = #{username} and blocked = 0")
	PersonLogin selectByUsername(@Param("username") String username);

}
