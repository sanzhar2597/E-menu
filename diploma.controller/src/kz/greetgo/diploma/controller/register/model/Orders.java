package kz.greetgo.diploma.controller.register.model;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	public Orders(){}

	public List<OrderItem> orderItems =new ArrayList<>();

	public Integer orderId;

	public String orderNo;

	public Integer customerId;

	public String pMethod;

	public Integer gTotal;

	public Integer bookingId;

	public Integer status;

	@Override
	public String toString() {

		return "Orders{" +
			"orderItems=" + orderItems +
			", orderId=" + orderId +
			", orderNo='" + orderNo + '\'' +
			", customerId=" + customerId +
			", pMethod='" + pMethod + '\'' +
			", gTotal=" + gTotal +
			", bookingId=" + bookingId +
			", status=" + status +
			'}';
	}
}
