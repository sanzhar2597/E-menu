package kz.greetgo.diploma.controller.register.model;

import java.util.Date;

public class FoodSchedule {

	public String id;

	public Date data;

	public Integer foodId;

	@Override
	public String toString() {

		return "FoodSchedule{" +
			"id='" + id + '\'' +
			", data=" + data +
			", foodId=" + foodId +
			'}';
	}
}
