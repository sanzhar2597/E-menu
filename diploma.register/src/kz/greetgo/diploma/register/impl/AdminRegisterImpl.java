package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.UserCan;
import kz.greetgo.diploma.controller.register.AdminRegister;
import kz.greetgo.diploma.controller.register.model.*;
import kz.greetgo.diploma.register.dao.AdminDao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static kz.greetgo.diploma.controller.util.FilterUtil.skipNulls;

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

	@Override
	public String saveMenuDay(FoodSchedule foodSchedule) {

		List<FoodSchedule> foodSchedules = new ArrayList<>();
		foodSchedule.data = new Timestamp(foodSchedule.data.getTime());

		System.out.println(foodSchedule);

		foodSchedules = adminDao.get().checkFoodSchedule(foodSchedule);


		if(foodSchedules.size() == 0)
			{
				adminDao.get().insertFoodSchedule(foodSchedule);
				return "empty";
			}
		return "full";
	}

	@Override
	public String saveRestaurantTable(Table table) {

		List<Table> tables = new ArrayList<>();
		tables = adminDao.get().selectRestaurantTable(table);

		if(tables.size() == 0)
			{
				adminDao.get().insertRestaurantTable(table);
				return "empty";
			} else
			{
				adminDao.get().updateRestaurantTable(table);
				return "full";
			}
	}

	@Override
	public List<FoodType> getFoodItem() {

		return adminDao.get().selectFoodItem();
	}

	@Override
	public List<FoodList> getFoodList(Integer id) {

		return adminDao.get().selectFoodList(id);

	}

	@Override
	public List<Table> getTableList() {

		return adminDao.get().getTableList();
	}

	@Override
	public List<UserCans> loadCans() {

		return adminDao.get().loadCans();
	}

	@Override
	public List<PersonDisplays> displayPerson() {

		List<PersonDisplays> personDisplays = new ArrayList<>();
		personDisplays = adminDao.get().loadDisplayPerson();

		for(PersonDisplays personDisplay : personDisplays)
			{
				personDisplay.cans = skipNulls(adminDao.get().loadCansInId(personDisplay.id));
			}

		return personDisplays;

	}

	@Override
	public String updatePersonCan(PersonDisplays personDisplays) {


		adminDao.get().deletePersonCanas(personDisplays.id);

		for(UserCan can : personDisplays.cans)
			{
				adminDao.get().inserPersonCans(personDisplays.id, can);
			}

		return "update";
	}

	public static void main(String[] args) {

		List<Item> items = new ArrayList<>();
		System.out.println(items.size());

	}

}
