package kz.greetgo.diploma.debug.launchers;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.gen.DepinjectUtil;
import kz.greetgo.diploma.controller.util.Modules;
import kz.greetgo.diploma.debug.bean_containers.DebugBeanContainer;

public class LaunchDebugServer {
  public static void main(String[] args) throws Exception {
    new LaunchDebugServer().run();
  }

  private void run() throws Exception {
    DepinjectUtil.implementAndUseBeanContainers(
      "kz.greetgo.diploma.debug",
      Modules.debugDir() + "/build/src_bean_containers");

    DebugBeanContainer container = Depinject.newInstance(DebugBeanContainer.class);

    container.server().start().join();
  }
}
