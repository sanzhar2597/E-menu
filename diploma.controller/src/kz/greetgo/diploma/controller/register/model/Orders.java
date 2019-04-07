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

}
