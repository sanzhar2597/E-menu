package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.register.model.*;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantOrderRegister {

	ArrayList<Item> getItemList();

	ArrayList<Customer> getCustomerList();

	void postOrderItems(Orders orders);

	List<OrderList> getOrderList();

	Orders getOrdersbyId(Integer id);

	String deleteOrderbyId(Integer id);
}
