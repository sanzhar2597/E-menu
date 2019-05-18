package kz.greetgo.diploma.controller.register.model;

public class Order {

	public Integer orderId;

	public String orderNo;

	public String personId;

	public String pMethod;

	public float gTotal;

	@Override
	public String toString() {

		return "Order{" +
			"orderId=" + orderId +
			", orderNo='" + orderNo + '\'' +
			", personId=" + personId +
			", pMethod='" + pMethod + '\'' +
			", gTotal=" + gTotal +
			'}';
	}


}
