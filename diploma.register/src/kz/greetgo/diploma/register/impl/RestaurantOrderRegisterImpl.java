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
	public void postOrderItems(Orders orders) {

		List<Order> orderList = new ArrayList<>();

		if(orders.orderId == 0)
			{
				int id = restaurantOrderDao.get().insertOorder(orders);
				for(OrderItem orderItem : orders.orderItems)
					{
						orderItem.orderId = id;
						restaurantOrderDao.get().inserOrderItem(orderItem);
					}
			} else
			{
				restaurantOrderDao.get().updateOorder(orders);
				for(OrderItem orderItem : orders.orderItems)
					{
						if(orderItem.orderItemId == null)
							{
								restaurantOrderDao.get().inserOrderItem(orderItem);
							} else
							{
								restaurantOrderDao.get().updaterderItem(orderItem);

							}
					}

			}
	}

	@Override
	public List<OrderList> getOrderList() {

		List<OrderList> orderLists = new ArrayList<>();
		orderLists = restaurantOrderDao.get().selectOrderList();
		return orderLists;
	}

	@Override
	public Orders getOrdersbyId(Integer id) {

		Orders orders = new Orders();
		List<OrderItem> orderItemList = new ArrayList<>();
		orders = restaurantOrderDao.get().selectorOrdersById(id);
		orderItemList = restaurantOrderDao.get().selectorOrderItemsById(id);
		for(OrderItem orderItem : orderItemList)
			{
				orders.orderItems.add(orderItem);
			}

		return orders;

	}

	@Override
	public String deleteOrderbyId(Integer id) {

		restaurantOrderDao.get().deleteOrderItemByorderId(id);
		restaurantOrderDao.get().deleteOrdeeById(id);
		System.out.println("deleted: " + id);
		return "deleted: " + id;
	}


}
