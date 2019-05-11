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
public class RestaurantOrderController implements Controller {

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
	@OnPost("/order-items")
	public void postOrderItems(@Par("orderItems") @Json Orders orders) {

		System.out.println(orders);

		restaurantOrderRegister.get().postOrderItems(orders);
	}

	@ToJson
	@PublicAccess
	@OnGet("/get-orders")
	public List<OrderList> getOrderList() {

		return restaurantOrderRegister.get().getOrderList();
	}

	@ToJson
	@PublicAccess
	@OnGet("/update-order-status")
	public void updateOrderStatus( @Par("orderList") @Json OrderList orderList) {

		 restaurantOrderRegister.get().updateOrderStatus(orderList);
	}

	@ToJson
	@PublicAccess
	@OnGet("/get-order")
	public Orders getOrdersbyId(@Par("id") @Json Integer id) {

		System.out.println(id);
		return restaurantOrderRegister.get().getOrdersbyId(id);
	}

	@ToJson
	@PublicAccess
	@OnGet("/delete-order")
	public void deleteOrderbyId(@Par("id") @Json Integer id) {

		System.out.println(id);
		restaurantOrderRegister.get().deleteOrderbyId(id);
	}

	@ToJson
	@PublicAccess
	@OnGet("/offer")
	public List<Item> prepareOffer(@Par("orderItems") @Json List<OrderItem> orderItems) {

		System.out.println(orderItems);
		return restaurantOrderRegister.get().prepareOffer(orderItems);
	}


}
