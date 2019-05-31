package kz.greetgo.diploma.controller.register.model;

public class Comments {

	public Integer id;

	public Integer itemId;

	public String personId;

	public String messages;

	@Override
	public String toString() {

		return "Comments{" +
			"id=" + id +
			", itemId=" + itemId +
			", personId='" + personId + '\'' +
			", messages='" + messages + '\'' +
			'}';
	}
}
