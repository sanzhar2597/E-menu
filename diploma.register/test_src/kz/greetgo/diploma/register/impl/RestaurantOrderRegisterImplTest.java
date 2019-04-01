package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.SessionHolder;
import kz.greetgo.diploma.controller.register.AuthRegister;
import kz.greetgo.diploma.controller.register.RestaurantOrderRegister;
import kz.greetgo.diploma.controller.register.model.Item;
import kz.greetgo.diploma.register.test.util.ParentTestNg;
import kz.greetgo.security.session.SessionIdentity;
import kz.greetgo.util.RND;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;

public class RestaurantOrderRegisterImplTest extends ParentTestNg {
	public BeanGetter<RestaurantOrderRegister> restaurantOrderRegister;



	@Test
	public void GetItemList() {

		ArrayList<Item> items = new ArrayList<Item>();

		items =restaurantOrderRegister.get().getItemList();

		System.out.println(items);
	}
}
