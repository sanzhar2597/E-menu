package kz.greetgo.diploma.controller.errors;

public class NoAccountName extends RestError {
  public NoAccountName() {
    super(400, "No account name");
  }
}
