package kz.greetgo.diploma.controller.errors;

public class NoPassword extends RestError {
  public NoPassword() {
    super(400, "No password");
  }
}
