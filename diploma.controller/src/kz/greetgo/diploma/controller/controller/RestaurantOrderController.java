package kz.greetgo.diploma.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.Item;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.mvc.annotations.AsIs;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;

import java.util.ArrayList;
import java.util.List;

@Bean
@ControllerPrefix("/restaurant")
public class RestaurantOrderController {
	public BeanGetter<RestaurantOrderRegister> restaurantOrderRegister;


	@ToJson
	@PublicAccess
	@OnGet("/list-item")
	public List<Item> getItemList() {
		return restaurantOrderRegister.get().getItemList();
	}

}
