package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.Item;
import kz.greetgo.diploma.register.dao.RestaurantOrderDao;

import java.util.ArrayList;

@Bean
public class RestaurantOrderRegisterImpl implements RestaurantOrderRegister {

	public BeanGetter<RestaurantOrderDao> restaurantOrderDao;

	@Override
	public ArrayList<Item> getItemList() {

		return restaurantOrderDao.get().selectItem();

	}
}
