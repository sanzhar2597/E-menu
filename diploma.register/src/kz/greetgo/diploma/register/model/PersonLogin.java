package kz.greetgo.diploma.register.model;

public class PersonLogin {

	public String id;

	public String encodedPassword;

	@Override
	public String toString() {

		return "person id is: " + id + ";\n" + "person encodedPassword is : " + encodedPassword + ";\n";
	}
}
