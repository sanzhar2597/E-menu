package kz.greetgo.diploma.controller.register;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.io.IOException;

public interface TelegramRegister {

	void setButtons(SendMessage sendMessage);

	void sendMsg(Message message, String text);

	String getNameFromDb(String name) throws IOException;

	String startBot(Message message);

}
