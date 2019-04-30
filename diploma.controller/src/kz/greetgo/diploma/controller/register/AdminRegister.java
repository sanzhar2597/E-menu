package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.register.model.FoodList;
import kz.greetgo.diploma.controller.register.model.FoodSchedule;
import kz.greetgo.diploma.controller.register.model.FoodType;
import kz.greetgo.diploma.controller.register.model.Item;

import java.util.List;

public interface AdminRegister {

	String saveProduct(Item item);

	String saveMenuDay(FoodSchedule foodSchedule);

	List<FoodType> getFoodItem();

	List<FoodList> getFoodList(Integer id);

}
