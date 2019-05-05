package kz.greetgo.diploma.controller.controller;

import javafx.scene.control.Tab;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.AdminRegister;
import kz.greetgo.diploma.controller.register.model.*;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.mvc.annotations.Json;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;

import java.util.List;

@Bean
@ControllerPrefix("/admin")
public class AdminContoller implements Controller {

	public BeanGetter<AdminRegister> adminRegister;

	@ToJson
	@PublicAccess
	@OnGet("/save-product")
	public String saveProduct(@Par("item") @Json Item item) {

		System.out.println(item);

		return adminRegister.get().saveProduct(item);
	}

	@ToJson
	@PublicAccess
	@OnGet("/save-menu-day")
	public String saveMenuDay(@Par("foodSchedule") @Json FoodSchedule foodSchedule) {

		System.out.println(foodSchedule);

		return adminRegister.get().saveMenuDay(foodSchedule);
	}


	@ToJson
	@PublicAccess
	@OnGet("/save-restaurant-table")
	public String saveRestaurantTable(@Par("table") @Json Table table) {

		return adminRegister.get().saveRestaurantTable(table);
	}

	@ToJson
	@PublicAccess
	@OnGet("/get-food-type")
	public List<FoodType> getFoodItem() {

		return adminRegister.get().getFoodItem();
	}

	@ToJson
	@PublicAccess
	@OnGet("/get-food-list")
	public List<FoodList> getFoodList(@Par("id") Integer id) {

		return adminRegister.get().getFoodList(id);
	}

	@ToJson
	@PublicAccess
	@OnGet("/get-table-list")
	public List<Table> getTableList() {

		return adminRegister.get().getTableList();
	}

}
