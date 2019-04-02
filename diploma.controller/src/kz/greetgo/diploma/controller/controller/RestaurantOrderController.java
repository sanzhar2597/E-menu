package kz.greetgo.diploma.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.*;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.Json;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;

import java.util.ArrayList;
import java.util.List;

@Bean
@ControllerPrefix("/restaurant")
public class RestaurantOrderController  implements Controller {

	public BeanGetter<RestaurantOrderRegister> restaurantOrderRegister;


	@ToJson
	@PublicAccess
	@OnGet("/list-item")
	public ArrayList<Item> getItemList() {

		return restaurantOrderRegister.get().getItemList();
	}

	@ToJson
	@PublicAccess
	@OnGet("/customer")
	public ArrayList<Customer> getCustomerList() {

		return restaurantOrderRegister.get().getCustomerList();
	}


	@PublicAccess
	@OnPost("/set-order")
	public void postOrder(@Par("order") @Json List<Order> orders) {


		restaurantOrderRegister.get().postOrders(orders);
	}

	@PublicAccess
	@OnPost("/order-item")
	public void postOrderItem(@Par("orderItems") @Json List<OrderItem> orderItems) {


		restaurantOrderRegister.get().postOrderItem(orderItems);
	}

	@PublicAccess
	@OnPost("/order-items")
	public void postOrderItem(@Par("orderItems") @Json OrderItem orderItem, @Par("order") Order order) {

		System.out.println(orderItem);

//		restaurantOrderRegister.get().postOrderItem(orderItems);
	}
	@ToJson
	@PublicAccess
	@OnGet("/get-orders")
	public List<OrderList> getOrderList() {
		return restaurantOrderRegister.get().getOrderList();
	}


}
