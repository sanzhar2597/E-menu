package kz.greetgo.diploma.register.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RestaurantOrderTestDao {

	@Insert("insert into item( name, price) " +
		"values (#{name}, #{price})")
	void insertItem(@Param("itemId") Integer itemId,
									@Param("name") String name,
									@Param("price") float price);

	@Insert("insert into customer(customer_id, name) " +
		"values (#{customerId}, #{name})")
	void insertCustomer(@Param("customerId") Integer customerId,
											@Param("name") String name);


	@Insert("insert into oorder(oorder_id, oorder_no, customer_id, p_method, g_total) " +
		"values (#{oorder_id}, #{oorder_no}, #{customer_id}, #{p_method}, #{g_total})")
	void insertOrder(@Param("oorder_id") Integer orderId,
									 @Param("oorder_no") String orderNO,
									 @Param("customer_id") Integer customerId,
									 @Param("p_method") String pMethod,
									 @Param("g_total") float gTotal);

}
