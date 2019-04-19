package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.AdminRegister;
import kz.greetgo.diploma.controller.register.model.Item;
import kz.greetgo.diploma.register.dao.AdminDao;

import java.util.ArrayList;
import java.util.List;

@Bean
public class AdminRegisterImpl implements AdminRegister {

	public BeanGetter<AdminDao> adminDao;

	@Override
	public String saveProduct(Item item) {

		List<Item> items = new ArrayList<>();
		items = adminDao.get().checkItem(item);

		if(items.size() == 0)
			{
				adminDao.get().insertItem(item);
				return "empty";
			}
		return "full";
	}

	public static void main(String[] args) {

		List<Item> items = new ArrayList<>();
		System.out.println(items.size());

	}

}
