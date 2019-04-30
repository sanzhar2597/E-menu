package kz.greetgo.diploma.controller.register.model;

public class FoodType {

	public Integer id;

	public String name;

	public String description;

	@Override
	public String toString() {

		return "FoodType{" +
			"id=" + id +
			", name='" + name + '\'' +
			", description='" + description + '\'' +
			'}';
	}
}
