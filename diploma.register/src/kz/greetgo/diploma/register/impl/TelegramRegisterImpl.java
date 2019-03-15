package kz.greetgo.diploma.register.impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.TelegramRegister;
import kz.greetgo.diploma.register.dao.TelegramDao;
import kz.greetgo.diploma.register.model.PersonLogin;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Bean
public class TelegramRegisterImpl extends TelegramLongPollingBot implements TelegramRegister {

	public BeanGetter<TelegramDao> telegramDao;

	@Override
	public void setButtons(SendMessage sendMessage) {

		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		sendMessage.setReplyMarkup(replyKeyboardMarkup);
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);

		List<KeyboardRow> keyboardRowList = new ArrayList<>();
		KeyboardRow keyboardFirstRow = new KeyboardRow();
		keyboardFirstRow.add(new KeyboardButton("/help"));

		KeyboardRow keyboardSecondRow = new KeyboardRow();
		keyboardSecondRow.add(new KeyboardButton("/using"));
		keyboardSecondRow.add(new KeyboardButton("/info"));
		keyboardRowList.add(keyboardFirstRow);
		keyboardRowList.add(keyboardSecondRow);
		replyKeyboardMarkup.setKeyboard(keyboardRowList);

	}

	@Override
	public void sendMsg(Message message, String text) {

		SendMessage sendMessage = new SendMessage();

		sendMessage.enableMarkdown(true);

		sendMessage.setChatId(message.getChatId());

		sendMessage.setReplyToMessageId(message.getMessageId());

		sendMessage.setText(text);
		try
			{

				setButtons(sendMessage);
				sendMessage(sendMessage);

			} catch(TelegramApiException e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public String getNameFromDb(String name) throws IOException {

		name = name.toLowerCase();
		PersonLogin selectByUsername = telegramDao.get().selectByUsername(name);
		System.out.println("telegram bot uses postgres");
		if(selectByUsername == null)
			{
				return "there is no such user";
			}
		return selectByUsername.toString();
	}

	@Override
	public String startBot(Message message) {

		String fullName = message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
		String firstMessage = "Добро пожаловать " + fullName + ". Вас приветсвует бот: " + getBotUsername();
		return firstMessage;
	}

	@Override
	public void onUpdateReceived(Update update) {

		Message message = update.getMessage();
		if(message != null && message.hasText())
			{
				switch(message.getText())
					{
						case "/start":
								sendMsg(message, startBot(message));
							break;
						case "/help":
							sendMsg(message, "Как пользоватся этим ботом ? \n" +
								"/help -Помощь Пользователю \n" +
								"/using - Что делает бот\n" +
								"/info - Информация о боте");
							break;
						case "/using":
							sendMsg(message,
								"Что делает бот? \nНужно просто написать ваше имя или имя друга \n" +
									"1) возвращает ваш уникальный id\n" +
									"2) возвращает ваше зашифрованное письмо");
							break;
						case "/info":
							sendMsg(message, "Бот разработан в 2019 году 10 марта. \nдля Дипломной Работы.");
							break;
						default:
							try
								{
									sendMsg(message, getNameFromDb(message.getText()));
								} catch(IOException e)
								{
									e.printStackTrace();
								}
					}
			}

	}

	@Override
	public void onUpdatesReceived(List<Update> updates) {

		for(Update update : updates)
			{
				onUpdateReceived(update);
			}
	}

	@Override
	public String getBotUsername() {

		return "booking_diploma_bot";
	}

	@Override
	public String getBotToken() {

		return "710526393:AAErOMh1RCoHX47Sz8U09XJEM6IbcInaTh8";
	}


}

