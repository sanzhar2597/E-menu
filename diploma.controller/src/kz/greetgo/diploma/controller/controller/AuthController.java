package kz.greetgo.diploma.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.AsIs;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParSession;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.mvc.annotations.on_methods.OnPost;
import kz.greetgo.mvc.interfaces.TunnelCookies;
import kz.greetgo.diploma.controller.model.PersonDisplay;
import kz.greetgo.diploma.controller.register.AuthRegister;
import kz.greetgo.diploma.controller.security.PublicAccess;
import kz.greetgo.diploma.controller.util.Controller;
import kz.greetgo.security.session.SessionIdentity;
import java.security.acl.*;
import javax.servlet.annotation.ServletSecurity;

import static kz.greetgo.diploma.controller.util.DiplomaViews.G_SESSION;

/**
 * как составлять контроллеры написано
 * <a href="https://github.com/greetgo/greetgo.mvc/blob/master/doc/controller_spec.md">здесь</a>
 */
@Bean
@ControllerPrefix("/auth")
public class AuthController implements Controller {

  public BeanGetter<AuthRegister> authRegister;

  @AsIs
  @PublicAccess
  @OnGet("/probe")
  public String probe() {
    return "System is working <b>OK</b>";
  }

  @AsIs
  @PublicAccess
  @OnPost("/login")
  public String login(@Par("username") String username,
                      @Par("password") String password,
                      TunnelCookies cookies) {

    SessionIdentity identity = authRegister.get().login(username, password);

    cookies.forName(G_SESSION)
      .path("/")
      .httpOnly(true)
      .maxAge(-1)
      .saveValue(identity.id);

    return identity.token;
  }

  @AsIs
  @PublicAccess
  @OnPost("/registrate")
  public String registrate(@Par("password") String password,  @Par("username") String accountName) {
    return authRegister.get().registrate(password, accountName);
  }

  @ToJson
  @PublicAccess
  @OnGet("/displayPerson")
  public PersonDisplay displayPerson(@ParSession("personId") String personId) {
    if(personId==null){
      return new PersonDisplay();

    }
    return authRegister.get().displayPerson(personId);
  }

  @AsIs
  @PublicAccess
  @OnGet("/exit")
  public void exit(@ParSession("sessionId") String sessionId, TunnelCookies cookies) {
    authRegister.get().deleteSession(sessionId);

    cookies.forName(G_SESSION)
      .path("/")
      .remove();
  }
}
