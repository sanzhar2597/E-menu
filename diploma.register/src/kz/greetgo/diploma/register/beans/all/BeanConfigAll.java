package kz.greetgo.diploma.register.beans.all;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.diploma.controller.controller.BeanConfigControllers;
import kz.greetgo.diploma.register.dao.postgres.BeanConfigPostgresDao;
import kz.greetgo.diploma.register.impl.BeanConfigRegisterImpl;

@BeanConfig
@BeanScanner
@Include({BeanConfigRegisterImpl.class, BeanConfigPostgresDao.class, BeanConfigControllers.class})
public class BeanConfigAll {}
