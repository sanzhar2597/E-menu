package kz.greetgo.diploma.controller.register.model;

import java.util.Date;

public class OrderStatus {

	public Integer orderId;
	public Integer orderItemId;
	public Date updateDate;
	public Integer status;

	@Override
	public String toString() {

		return "OrderStatus{" +
			"orderId=" + orderId +
			", orderItemId=" + orderItemId +
			", updateDate=" + updateDate +
			", status=" + status +
			'}';
	}
}
