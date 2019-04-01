package kz.greetgo.diploma.controller.register.model;

public class Item {
	public int itemId;
	public String name;
	public float price;

	@Override
	public String toString() {

		return "Item{" +
			"itemId=" + itemId +
			", name='" + name + '\'' +
			", price=" + price +
			'}';
	}
}
