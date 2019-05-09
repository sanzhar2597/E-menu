package kz.greetgo.diploma.controller.register.model;

public class FoodList {


	public Integer id;

	public String name;

	public Integer type;

	public String price;


	@Override
	public String toString() {

		return "FoodList{" +
			"id=" + id +
			", name='" + name + '\'' +
			", type=" + type +
			", price='" + price + '\'' +
			'}';
	}

}
