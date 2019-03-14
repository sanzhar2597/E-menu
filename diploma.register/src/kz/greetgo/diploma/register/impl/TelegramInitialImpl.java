package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.TelegramInitial;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@Bean
public class TelegramInitialImpl implements TelegramInitial {

	public BeanGetter<TelegramRegisterImpl> telegramRegisterImpl;

	@Override
	public void startTelegram() {

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try
			{
				telegramBotsApi.registerBot(telegramRegisterImpl.get());

			} catch(TelegramApiRequestException e)
			{
				e.printStackTrace();
			}

	}

}
