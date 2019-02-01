package kz.greetgo.diploma.controller.errors;

public class NotFound extends RestError {
  public NotFound() {
    super(404, "Not Found");
  }
}
