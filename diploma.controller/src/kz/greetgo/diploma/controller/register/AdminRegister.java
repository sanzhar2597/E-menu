package kz.greetgo.diploma.controller.register;

import kz.greetgo.diploma.controller.register.model.*;

import java.util.List;

public interface AdminRegister {

	String saveProduct(Item item);

	String saveMenuDay(FoodSchedule foodSchedule);

	String saveRestaurantTable(Table table);

	List<FoodType> getFoodItem();

	List<FoodList> getFoodList(Integer id);

	List<Table> getTableList();

	List<UserCans> loadCans();

	List<PersonDisplays> displayPerson();

	String updatePersonCan(PersonDisplays personDisplays);
}
