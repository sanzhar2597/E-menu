package kz.greetgo.diploma.controller.register.model;

public class FoodList {

	public Integer id;

	public String name;

	public Integer type;

	@Override
	public String toString() {

		return "FoodList{" +
			"id=" + id +
			", name='" + name + '\'' +
			", type=" + type +
			'}';
	}
}
