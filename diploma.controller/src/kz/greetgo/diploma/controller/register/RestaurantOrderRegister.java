package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.register.model.*;

import java.util.ArrayList;
import java.util.List;

public interface RestaurantOrderRegister {

	ArrayList<Item> getItemList();
	ArrayList<Customer> getCustomerList();

	void postOrders(List<Order> order);

	void postOrderItem(List<OrderItem> orderItems);

	List<OrderList> getOrderList();
}
