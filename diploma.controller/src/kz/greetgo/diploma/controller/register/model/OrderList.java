package kz.greetgo.diploma.controller.register.model;

public class OrderList {

	public Integer orderId;

	public String orderNo;

	public String name;

	public float gTotal;

	public String pMethod;

	public Integer status;

	@Override
	public String toString() {

		return "OrderList{" +
			"orderId=" + orderId +
			", orderNo='" + orderNo + '\'' +
			", name='" + name + '\'' +
			", gTotal=" + gTotal +
			", pMethod='" + pMethod + '\'' +
			", status=" + status +
			'}';
	}
}
