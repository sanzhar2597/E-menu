package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.model.PersonRecord;
import kz.greetgo.diploma.controller.register.PersonRegister;
import kz.greetgo.diploma.register.dao.PersonDao;

import java.util.List;

@Bean
public class PersonRegisterImpl implements PersonRegister {
  public BeanGetter<PersonDao> personDao;

  @Override
  public List<PersonRecord> list() {
    return personDao.get().list();
  }
}
