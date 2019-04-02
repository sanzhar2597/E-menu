package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.*;
import kz.greetgo.diploma.register.dao.RestaurantOrderDao;

import java.util.ArrayList;
import java.util.List;

@Bean
public class RestaurantOrderRegisterImpl implements RestaurantOrderRegister {

	public BeanGetter<RestaurantOrderDao> restaurantOrderDao;

	@Override
	public ArrayList<Item> getItemList() {

		return restaurantOrderDao.get().selectItem();

	}

	@Override
	public ArrayList<Customer> getCustomerList() {

		return restaurantOrderDao.get().selectCustomer();
	}

	@Override
	public void postOrders(List<Order> orders) {
		for(Order order: orders){
			restaurantOrderDao.get().inserOorder(order);
		}
		
	}

	@Override
	public void postOrderItem(List<OrderItem> orderItems) {
		for(OrderItem orderItem: orderItems){
			orderItem.orderId=1;
			restaurantOrderDao.get().inserOrderItem(orderItem);
		}
	}

	@Override
	public List<OrderList> getOrderList() {
		List<OrderList> orderLists = new ArrayList<>();
		orderLists = restaurantOrderDao.get().selectOrderList();
		return orderLists;
	}


}
