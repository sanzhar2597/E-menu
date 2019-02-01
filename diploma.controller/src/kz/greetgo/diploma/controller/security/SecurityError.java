package kz.greetgo.diploma.controller.security;


import kz.greetgo.diploma.controller.errors.RestError;

public class SecurityError extends RestError {
  public SecurityError() {
    this("Security error");
  }

  public SecurityError(String message) {
    super(401, message);
  }
}
