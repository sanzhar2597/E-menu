package kz.greetgo.diploma.controller.register.model;

public class Person {

	public String personId;

	@Override
	public String toString() {

		return "Person{" +
			"cusomerId=" + personId +
			", name='" + name + '\'' +
			'}';
	}

	public String name;
}
