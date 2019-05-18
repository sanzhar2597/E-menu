package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RestaurantOrderTestDao {

	@Insert("insert into item( name, price) " +
		"values (#{name}, #{price})")
	void insertItem(@Param("itemId") Integer itemId,
									@Param("name") String name,
									@Param("price") float price);

	@Insert("insert into customer(person_id, name) " +
		"values (#{personId}, #{name})")
	void insertCustomer(@Param("personId") String personId,
											@Param("name") String name);


	@Insert("insert into oorder(oorder_id, oorder_no, person_id, p_method, g_total) " +
		"values (#{oorder_id}, #{oorder_no}, #{person_id}, #{p_method}, #{g_total})")
	void insertOrder(@Param("oorder_id") Integer orderId,
									 @Param("oorder_no") String orderNO,
									 @Param("person_id") String personId,
									 @Param("p_method") String pMethod,
									 @Param("g_total") float gTotal);

}
