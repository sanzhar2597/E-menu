package kz.greetgo.diploma.debug.bean_containers;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.diploma.controller.controller.BeanConfigControllers;
import kz.greetgo.diploma.register.beans.all.BeanConfigAll;
import kz.greetgo.diploma.debug.beans.BeanConfigStand;

@BeanConfig
@Include({BeanConfigStand.class, BeanConfigControllers.class, BeanConfigAll.class})
public class BeanConfigForDebugBeanContainer {}
