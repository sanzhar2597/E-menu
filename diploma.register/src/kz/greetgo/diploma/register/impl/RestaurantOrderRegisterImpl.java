package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.*;
import kz.greetgo.diploma.register.dao.RestaurantOrderDao;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

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

	@Override
	public List<Item> prepareOffer(List<OrderItem> orderItems) {


		String collect = orderItems.stream().map(orderItem -> orderItem.itemId + "").collect(joining(","));
		List<Item> items = new ArrayList<>();
		List<ItemCount> itemCounts = new ArrayList<>();
		itemCounts = restaurantOrderDao.get().prepareOffer(collect);
		if(itemCounts.size() == 0)
			{
				return items;
			}
		for(ItemCount itemCount : itemCounts)
			{
				System.out.println(itemCount);
				items.add(restaurantOrderDao.get().selectItemById(itemCount.itemId));
			}
		return items;
	}

	;


	public static void main(String[] args) {

		List<Item> list = new ArrayList<>();
		{
			Item item = new Item();
			item.itemId = 1;
			list.add(item);
		}

		{
			Item item = new Item();
			item.itemId = 2;
			list.add(item);
		}

		{
			Item item = new Item();
			item.itemId = 3;
			list.add(item);
		}

		System.out.println(list);


		String collect = list.stream().map(item -> item.itemId + "").collect(joining(","));

		System.out.println(collect);

	}

}
