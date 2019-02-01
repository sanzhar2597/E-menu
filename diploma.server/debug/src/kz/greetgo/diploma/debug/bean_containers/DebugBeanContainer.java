package kz.greetgo.diploma.debug.bean_containers;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.diploma.debug.beans.DebugServer;

@Include(BeanConfigForDebugBeanContainer.class)
public interface DebugBeanContainer extends BeanContainer {
  DebugServer server();
}
