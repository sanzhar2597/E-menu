package kz.greetgo.diploma.controller.model;

import java.util.Date;

public class TelegramMenu {
	public String foodType;
	public String foodName;

	@Override
	public String toString() {

		return "TelegramMenu{" +
			"foodType='" + foodType + '\'' +
			", foodName='" + foodName + '\'' +
			'}';
	}
}
