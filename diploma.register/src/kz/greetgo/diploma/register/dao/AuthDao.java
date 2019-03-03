package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.register.model.PersonLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AuthDao {
  @Select("select * from person where username = #{username} and blocked = 0")
  PersonLogin selectByUsername(@Param("username") String username);

  @Select("select surname||' '||name||' '||patronymic as fio, username" +
    " from person where id = #{personId}")
  PersonDisplay loadDisplayPerson(@Param("personId") String personId);

  @Select("select user_can from person_cans where person_id = #{personId}")
  List<UserCan> loadCans(String personId);

  @Insert("insert into Person (id, username, encoded_password, blocked) " +
          "values (#{id}, #{username}, #{encodedPassword}, 0)")
  void insertPerson(@Param("id") String id,
                    @Param("username") String username,
                    @Param("encodedPassword") String encodedPassword
  );

  @Update("update Person set ${fieldName} = #{fieldValue} where id = #{id}")
  void updatePersonField(@Param("id") String id,
                         @Param("fieldName") String fieldName,
                         @Param("fieldValue") Object fieldValue);

}
