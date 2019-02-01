package kz.greetgo.diploma.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.ToJson;
import kz.greetgo.mvc.annotations.on_methods.ControllerPrefix;
import kz.greetgo.mvc.annotations.on_methods.OnGet;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.register.PersonRegister;
import kz.greetgo.diploma.controller.util.Controller;

import java.util.List;

@Bean
@ControllerPrefix("/person")
public class PersonController implements Controller {

  public BeanGetter<PersonRegister> personRegister;

  @ToJson
  @OnGet("/list")
  public List<PersonRecord> list() {
    return personRegister.get().list();
  }

}
