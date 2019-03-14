package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.register.test.util.ParentTestNg;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.testng.annotations.Test;

public class TelegramRegisterImplTest extends ParentTestNg {

	public BeanGetter<TelegramRegisterImpl> telegramRegisterImpl;

	@Test
	public void InitializeTelegram() {

		ApiContextInitializer.init();

		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try
			{
				telegramBotsApi.registerBot(telegramRegisterImpl.get());

			} catch(TelegramApiRequestException e)
			{
				e.printStackTrace();
			}

		while(true)
			{

			}
	}
}