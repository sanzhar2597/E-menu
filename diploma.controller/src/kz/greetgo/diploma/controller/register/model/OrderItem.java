package kz.greetgo.diploma.controller.register.model;

public class OrderItem {

	@Override
	public String toString() {

		return "OrderItem{" +
			"orderItemId=" + orderItemId +
			", orderId=" + orderId +
			", itemId=" + itemId +
			", quantity=" + quantity +
			", itemName='" + itemName + '\'' +
			", price=" + price +
			", total=" + total +
			'}';
	}

	public Integer orderItemId;

	public Integer orderId;

	public Integer itemId;

	public Integer quantity;

	public String itemName;

	public float price;

	public float total;
}
