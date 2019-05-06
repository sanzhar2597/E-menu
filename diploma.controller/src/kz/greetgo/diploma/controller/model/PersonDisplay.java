package kz.greetgo.diploma.controller.model;

import java.util.ArrayList;
import java.util.List;

public class PersonDisplay {

	public String fio;

	public String username;

	public String role;

	public List<UserCan> cans = new ArrayList<>();

	@Override
	public String toString() {

		return "PersonDisplay{" +
			"fio='" + fio + '\'' +
			", username='" + username + '\'' +
			", role='" + role + '\'' +
			", cans=" + cans +
			'}';
	}
//The following code would be not removed after regenerating
	///LEAVE_FURTHER
}
