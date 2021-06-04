package kz.greetgo.diploma.register.test.beans.develop;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.register.beans.all.IdGenerator;
import kz.greetgo.diploma.register.test.dao.AuthTestDao;
import kz.greetgo.diploma.register.test.dao.TelegramMenuTestDao;
import kz.greetgo.security.password.PasswordEncoder;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Bean
public class DbTelegramMenuLoader {

	final Logger logger = Logger.getLogger(getClass());


	public BeanGetter<AuthTestDao> authTestDao;

	public BeanGetter<IdGenerator> idGenerator;

	public BeanGetter<PasswordEncoder> passwordEncoder;

	public BeanGetter<TelegramMenuTestDao> telegramMenuTestDao;

	private Integer idIncreased = 0;

	public void loadTestData() throws Exception {

		loadTelegramMenu();
		logger.info("FINISH");

	}

	private void loadTelegramMenu() throws Exception {

		logger.info("Start loading telegram menu...");
		loadFoodType();
		loadFoodList();
		loadFoodSchedule();
	}

	private void addFoodType(String id, String name) {

		name = name.toLowerCase();
		String description = "undefined";

		telegramMenuTestDao.get().insertFoodType(id, name, description);
	}

	private void addFoodType(String id, String name, String description) {

		name = name.toLowerCase();
		description = description.toLowerCase();

		telegramMenuTestDao.get().insertFoodType(id, name, description);
	}

	private void addFoodList(String id, String name, String type, String price) {

		name = name.toLowerCase();
		telegramMenuTestDao.get().insertFoodList(id, name, type, price);
	}

	private void addFoodSchedule(String data, String foodId) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(data);
		String id = idGenerator.get().newId();
		telegramMenuTestDao.get().insertFoodSchedule(id, new Timestamp(date.getTime()), foodId);
	}


	private String increaseIdincreased() {

		++idIncreased;
		return Integer.toString(idIncreased);
	}

	private String setidIncreased(Integer id) {

		if(id < 2)
			{
				id = 1;
			}
		idIncreased = id;
		return Integer.toString(idIncreased);
	}

	private String takeDefaultIdIncreased() {

		idIncreased = 1;
		return Integer.toString(idIncreased);
	}

	private void loadFoodType() {

		addFoodType(takeDefaultIdIncreased(), "Алматы-Астана", "Алматы-Астана"); // id 1
		addFoodType(increaseIdincreased(), "Шымкент-Астана", "Шымкент-Астана"); // id 2
		addFoodType(increaseIdincreased(), "Астана-Кызылорда", "Астана-Кызылорда"); // // id 3
		addFoodType(increaseIdincreased(), "Кызылорда-Караганда", "Кызылорда-Караганда"); // id 4
		addFoodType(increaseIdincreased(), "Караганда-Сарыагаш", "Караганда-Сарыагаш"); // id 5
		addFoodType(increaseIdincreased(), "Алматы-Туркестан", "Алматы-Туркестан"); // id 6
		addFoodType(increaseIdincreased(), "Алматы-Кокшетау", "Алматы-Кокшетау"); // id 7
		addFoodType(increaseIdincreased(), "Алматы-Тараз", "Алматы-Тараз"); // id 8
		addFoodType(increaseIdincreased(), "Алматы-Жетисай", "Алматы-Жетисай"); // id 9
		addFoodType(increaseIdincreased(), "Алматы-Караганда", "Алматы-Караганда"); // id 10
		addFoodType(increaseIdincreased(), "Алматы-Кентау", "Алматы-Кентау"); // id 11
		addFoodType(increaseIdincreased(), "Кентау-Шымкент", "Алматы-Кентау"); // id 12
		addFoodType(increaseIdincreased(), "Атырау-Кентау", "Алматы-Кентау"); // id 13
		addFoodType(increaseIdincreased(), "Актау-Атырау", "Алматы-Кентау"); // id 14
		addFoodType(increaseIdincreased(), "Алматы-Актобе", "Алматы-Кентау"); // id 15

	}

	private void loadFoodList() {

		addFoodList(takeDefaultIdIncreased(), "Автобус МАЗ-232", "1", "время отправки:17:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус МАЗ-232", "1", "время отправки:18:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус КАЗ-233", "2", "время отправки:19:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус VAN-213", "2", "время отправки:18:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус SAD-121", "3", "время отправки:17:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус XOKO-210", "4", "время отправки:14:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус МАЗ-90", "4", "время отправки:16:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус VOLVO-23", "5", "время отправки:15:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус HALL-998", "5", "время отправки:19:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус JRT-323", "6", "время отправки:18:00, стоимость:8000тг");
		addFoodList(increaseIdincreased(), "Автобус МNH-324", "7", "время отправки:20:00, стоимость:8000тг");
		addFoodList(increaseIdincreased(), "Автобус KJK-334", "8", "время отправки:21:00, стоимость:9000тг");
		addFoodList(increaseIdincreased(), "Автобус ASX-234", "8", "время отправки:21:00, стоимость:3000тг");
		addFoodList(increaseIdincreased(), "Автобус ASA-566", "9", "время отправки:20:00, стоимость:4000тг");
		addFoodList(increaseIdincreased(), "Автобус QWE-453", "9", "время отправки:18:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус JKL-098", "9", "время отправки:19:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус XZC-976", "10", "время отправки:19:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус ZXC-987", "10", "время отправки:14:00, стоимость:8000тг");
		addFoodList(increaseIdincreased(), "Автобус WQF-342", "10", "время отправки:11:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус ETY-458", "10", "время отправки:18:00, стоимость:4000тг");
		addFoodList(increaseIdincreased(), "Автобус XCD-768", "11", "время отправки:16:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус GHK-345", "11", "время отправки:19:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус ZXC-978", "11", "время отправки:19:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус DGG-656", "11", "время отправки:15:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус KOO-768", "12", "время отправки:16:00, стоимость:8000тг");
		addFoodList(increaseIdincreased(), "Автобус ZXC-167", "13", "время отправки:13:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус LKL-879", "14", "время отправки:19:00, стоимость:7000тг");
		addFoodList(increaseIdincreased(), "Автобус МАЗ-232", "14", "время отправки:10:00, стоимость:8000тг");
		addFoodList(increaseIdincreased(), "Автобус МАЗ-234", "15", "время отправки:13:00, стоимость:9000тг");
		addFoodList(increaseIdincreased(), "Автобус МАЗ-200", "15", "время отправки:15:00, стоимость:4000тг");
		addFoodList(increaseIdincreased(), "Автобус ASA-230", "15", "время отправки:19:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус FGH-454", "4", "время отправки:18:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус GGG-555", "4", "время отправки:17:00, стоимость:6000тг");
		addFoodList(increaseIdincreased(), "Автобус OOO-000", "3", "время отправки:17:00, стоимость:5000тг");
		addFoodList(increaseIdincreased(), "Автобус МER-456", "5", "время отправки:22:00, стоимость:7000тг");
	}

	private void loadFoodSchedule() throws ParseException {

		addFoodSchedule("2021-06-05", takeDefaultIdIncreased());


		for(int loopDay = 0; loopDay < 15; loopDay++)
			{
				for(int i = 0; i < 15; i++)
					{

						try
							{
								String day = "";
								int twoLength = Integer.toString(loopDay + 2).length();
								if(twoLength < 2)
									{
										day = "0" + (loopDay + 2);
									} else
									{
										day = "" + (loopDay + 2);
									}
								String fullDate = "2021-06-" + day;

								Integer rand = (int) (1 + Math.random() * 33);
								String randFoodId = Integer.toString(rand);

								addFoodSchedule(fullDate, randFoodId);
							} catch(Exception e)
							{
								//Нужно для того чтоб если рандомное число повторилась, он не добавит в бд, и выведет ошибку,
								// и тогда мы заново цикл начинаем чтоб рандомное число не повторилась так как  ключ базы data и food_id есть primary key
								i--;
							}
					}
			}


	}

}
