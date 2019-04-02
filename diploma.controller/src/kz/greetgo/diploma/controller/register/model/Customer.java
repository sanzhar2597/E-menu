package kz.greetgo.diploma.controller.register.model;

public class Customer {

	public Integer customerId;

	@Override
	public String toString() {

		return "Customer{" +
			"cusomerId=" + customerId +
			", name='" + name + '\'' +
			'}';
	}

	public String name;
}
