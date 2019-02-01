package kz.greetgo.diploma.server.app;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.diploma.register.beans.all.BeanConfigAll;
import kz.greetgo.diploma.server.beans.BeanConfigServer;

@BeanConfig
@Include({BeanConfigServer.class, BeanConfigAll.class})
public class BeanConfigApplication {}
