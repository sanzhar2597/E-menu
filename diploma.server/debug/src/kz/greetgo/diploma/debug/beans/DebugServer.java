package kz.greetgo.diploma.debug.beans;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.core.HasAfterInject;
import kz.greetgo.diploma.controller.util.Modules;
import kz.greetgo.diploma.debug.util.WebAppContextRegistration;
import kz.greetgo.diploma.register.impl.TelegramInitialImpl;
import kz.greetgo.diploma.register.impl.TelegramRegisterImpl;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.Comparator;
import java.util.List;

@Bean
public class DebugServer implements HasAfterInject {
  private static final int PORT = 13_13/* Reptilians is out of there */;
  public final Server server = new Server(PORT);

  public DebugServer start() throws Exception {
    server.start();
    String url = "Go to http://localhost:" + PORT + "/diploma/api/auth/probe";
    System.err.println("[[[                                ]]]");
    System.err.println("[[[ Stand server has been launched ]]] [[[ " + url + " ]]]");
    System.err.println("[[[                                ]]]");
    telegramStart();
    return this;
  }
  public BeanGetter<TelegramInitialImpl> telegramInitialImpl;

  public void telegramStart(){
		System.err.println("[[[                                ]]]");
		System.err.println("[[[ Telegram bot has been launched ]]]");
		System.err.println("[[[                                ]]]");
    telegramInitialImpl.get().startTelegram();
  }

  public void join() throws InterruptedException {
    server.join();
  }

  public BeanGetter<List<WebAppContextRegistration>> webAppContextRegistrations;

  @Override
  public void afterInject() throws Exception {
    WebAppContext webAppServlet = new WebAppContext(
      Modules.clientDir().toPath().resolve(".").toString(),
      "/diploma");

    webAppContextRegistrations.get().stream()
      .sorted(Comparator.comparingDouble(WebAppContextRegistration::priority))
      .forEachOrdered(r -> r.registerTo(webAppServlet));

    server.setHandler(webAppServlet);
  }
}
