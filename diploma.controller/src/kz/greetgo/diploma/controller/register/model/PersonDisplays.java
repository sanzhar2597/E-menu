package kz.greetgo.diploma.controller.register.model;

import kz.greetgo.diploma.controller.model.PersonDisplay;

public class PersonDisplays extends PersonDisplay {

	public String id;

	@Override
	public String toString() {

		return "PersonDisplays{" +
			"id='" + id + '\'' +
			", fio='" + fio + '\'' +
			", username='" + username + '\'' +
			", role='" + role + '\'' +
			", cans=" + cans +
			'}';
	}
}
