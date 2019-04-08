package kz.greetgo.diploma.register.dao;

import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.controller.register.model.*;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantOrderDao {

	@Select("select *from item")
	ArrayList<Item> selectItem();

	@Select("select customer_id as customerId, name as name from customer")
	ArrayList<Customer> selectCustomer();


	@Select("insert into oorder( oorder_no, customer_id, p_method, g_total) " +
		"values (#{order.orderNo}, #{order.customerId}, #{order.pMethod}, #{order.gTotal}) returning oorder_id" )
	Integer insertOorder(@Param("order") Orders orders);

	@Update("update oorder set " +
		"oorder_no =#{orders.orderNo}, customer_id= #{orders.customerId}, " +
		"p_method= #{orders.pMethod}, g_total= #{orders.gTotal} " +
		"where oorder_id = #{orders.orderId}")
	void updateOorder(@Param("orders") Orders orders);

	@Update("update order_items set " +
		"oorder_id =#{orderItem.orderId}, " +
		"item_id= #{orderItem.itemId}, " +
		"quantity= #{orderItem.quantity} " +
		"where order_item_id = #{orderItem.orderItemId} ")
	void updaterderItem(@Param("orderItem") OrderItem orderItem);

	@Insert("insert into order_items( oorder_id, item_id, quantity) " +
		"values (#{order.orderId}, #{order.itemId}, #{order.quantity})")
	void inserOrderItem(@Param("order") OrderItem orderItem);

	@Select("select o.oorder_id as orderId, o.oorder_no as orderNo," +
		" c.name as name , o.g_total as gTotal, o.p_method as pMethod from\n" +
		"  oorder o inner join customer c on o.customer_id= c.customer_id\n")
	List<OrderList> selectOrderList();

	@Select("select o.oorder_id as orderId, o.oorder_no as orderNo," +
		" c.name as name , o.g_total as gTotal, o.p_method as pMethod from\n" +
		"  oorder o inner join customer c on o.customer_id= c.customer_id " +
		"where o.oorder_id = #{id}\n")
	List<OrderList> selectorderById(@Param("id") Integer id );

	@Delete("delete from oorder where oorder_id = #{id}")
	void deleteOrdeeById(@Param("id") Integer id);

	@Delete("delete from order_items where oorder_id = #{id}")
	void deleteOrderItemByorderId(@Param("id") Integer id);

	@Select("select surname||' '||name||' '||patronymic as fio, username" +
		" from person where id = #{personId}")
	PersonDisplay loadDisplayPerson(@Param("personId") String personId);

	@Select("select oorder_id as orderId, oorder_no as orderNo, " +
		"customer_id as customerId, p_method as pMethod, " +
		" g_total as gTotal from oorder where oorder_id = #{id}")
	Orders selectorOrdersById(@Param("id") Integer id);

	@Select("select\n" +
		"  o.order_item_id as orderItemId,\n" +
		"  o.oorder_id as orderId,\n" +
		"  o.item_id as itemId,\n" +
		"  o.quantity as quantity,\n" +
		"  i.name as itemName,\n" +
		"  i.price as price,\n" +
		"  oo.g_total as total\n" +
		"from order_items as o\n" +
		"  inner join  item as i on o.item_id=i.item_id\n" +
		"  inner join oorder as oo on o.oorder_id = oo.oorder_id where o.oorder_id = #{id}")
	List<OrderItem> selectorOrderItemsById(@Param("id") Integer id);

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
