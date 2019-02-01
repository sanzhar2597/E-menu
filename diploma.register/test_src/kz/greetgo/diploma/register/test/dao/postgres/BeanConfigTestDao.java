package kz.greetgo.diploma.register.test.dao.postgres;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.BeanScanner;
import kz.greetgo.diploma.register.beans.all.DaoImplFactory;

@BeanScanner
@BeanConfig(factory = DaoImplFactory.class)
public class BeanConfigTestDao {}
