package kz.greetgo.diploma.register.test.beans.develop;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.register.test.dao.RestaurantOrderTestDao;
import org.apache.log4j.Logger;

@Bean
public class DbRestaurantOrderLoader {

	final Logger logger = Logger.getLogger(getClass());


	public BeanGetter<RestaurantOrderTestDao> restaurantOrderTestDao;

	public Integer idIncreased = 1;

	public void loadTestData() throws Exception {

		loadRestaurantOrder();
		loadCustomer();
		logger.info("FINISH");
	}

	@SuppressWarnings("SpellCheckingInspection")
	private void loadRestaurantOrder() throws Exception {

		logger.info("Start loading travel bus order...");


		loadItem();
		logger.info("Finish loading persons");
	}


	private Integer increaseIdincreased() {

		++idIncreased;
		return idIncreased;
	}

	private Integer setidIncreased(Integer id) {

		if(id < 2)
			{
				id = 1;
			}
		idIncreased = id;
		return idIncreased;
	}

	private Integer takeDefaultIdIncreased() {

		idIncreased = 1;
		return idIncreased;
	}


	private void addItem(Integer id, String name, float price, String category, String description, String image) {

		restaurantOrderTestDao.get().insertItem(id, name, price, category, description, image);
	}

	private void addCustomer(String id, String name) {

		restaurantOrderTestDao.get().insertCustomer(id, name);
	}

	private void loadItem() {

		addItem(increaseIdincreased(), "Микроавтобус Hyundai H350", (float) 72000, "menu-2",
			"Микроавтобус «Н350» – комфортабельный пассажирский коммерческий автомобиль для корпоративных перевозок персонала или работы на городских маршрутах. Он создан на базе одноименного грузового фургона, но в плане оснащения стремится задать новые стандарты в своем сегменте.\n",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/07/H350BUS-tmb.jpg");
		addItem(increaseIdincreased(), "Мерседес спринтер 2", (float) 65000, "menu-2",
			"«Штутгартский минибус» 2-го поколения появился на свет в апреле 2006-го, после чего неоднократно обновлялся. Он обладает симпатичной внешностью и широким выбором модификаций (отличающихся назначением, габаритами, вместимостью и моторами).",
			"https://truck.ironhorse.ru/wp-content/uploads/2014/08/Sprinter-906-Bus-tmb.jpg");
		addItem(increaseIdincreased(), "Микроавтобус Citroen Jumpy 3", (float) 60000, "menu-2",
			"Третья генерация микроавтобуса была официально представлена в конце марта 2016 года, после чего поступила в продажу. Тут традиционно: несколько модификаций на выбор, современный и вместительный салон, а также производительные и экономичные дизельные «четверки».",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/11/Jumpy-3-Combi-tmb.jpg");
		addItem(increaseIdincreased(), "Микроавтобус Газель-Бизнес", (float) 40000, "menu-2",
			"Обзор универсального пассажирского микроавтобуса «ГАЗель-Бизнес» (ГАЗ-3221), имеющего широкий спектр модификаций, отличающихся исполнением салона, вариантами силовой установки и типом привода.",
			"https://truck.ironhorse.ru/wp-content/uploads/2014/01/3221b.jpg");
		addItem(increaseIdincreased(), "Микроавтобус Соболь", (float) 45000, "menu-2",
			"Первое «поколение» микроавтобусов семейства «Соболь» (представленное в 1998 году и обновленное в 2003-м) имеет два варианта компоновки салона (7 или 11 мест), широкий выбор моторов и два варианта «колесной формулы» (заднеприводный ГАЗ-22171 или полноприводный ГАЗ-221717).",
			"https://truck.ironhorse.ru/wp-content/uploads/2010/01/22171.jpg");
		addItem(increaseIdincreased(), "1-ый Микроавтобус Мерседес бенз", (float) 68000, "menu-2",
			"Первый «релиз» пассажирской модели с индексом «W638» появился на свет в 1995 году, а серийно выпускался до 2005-го. Она может похвастать: опрятной внешностью, качественным и вместительным салоном, надежной техникой и широчайшим выбором двигателей.",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/08/Vito-Bus-638-tmb.jpg");
		addItem(takeDefaultIdIncreased(), "Небольшой междугородец МАЗ-232", (float) 100000, "menu-1",
			"Автобус среднего класса, созданный для пригородных, междугородных и туристических перевозок, начал свою серийную «карьеру» в 2014 году. Среди его особенностей числятся: современный внешний вид, вместительный и комфортабельный салон и 218-сильный дизельный двигатель.",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/09/232-tmb.jpg");
		addItem(increaseIdincreased(), "Туристические MAN Lions Coach", (float) 120000, "menu-1",
			"Это – двух- или трехосный автобус большого класса, предназначенный для туристических пассажирских перевозок (на большие расстояния).  Он может похвастать респектабельным дизайном, комфортабельным салоном, надежной техникой и высокопроизводительными моторами.",
			"https://truck.ironhorse.ru/wp-content/uploads/2018/05/Lions-Coach-tmb.jpg");
		addItem(increaseIdincreased(), "Люксбус Volvo 9900", (float) 150000, "menu-1",
			"Это – туристический автобус класса «люкс», который начал свою серийную «карьеру» еще в 2001 году. Для него предусмотрено несколько модификаций (отличающихся габаритами, количеством посадочных мест, мощностью двигателя и уровнем оснащения).",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/07/9900-tmb.jpg");
		addItem(increaseIdincreased(), "Комфортабельный Volvo 9700", (float) 200000, "menu-1",
			"Данный комфортабельный автобус появился на свет в 2001-м, а после пережил две «реинкарнации» – в 2006 и 2012 годах. Он отличается современной внешностью и продуманным салоном и предлагается в нескольких модификациях, отличающихся мощностью и колесной формулой. ",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/07/9700-tmb.jpg");
		addItem(increaseIdincreased(), "Межгород-турист", (float) 230000, "menu-1",
			"Это – семейство автобусов, выступающих в сегменте междугородних и туристических перевозок, которое появилось на свет в 2009 году. Они предлагаются в двух- или трехосных исполнениях, имеют от 49 до 59 посадочных мест в салоне, а оснащаются шестицилиндровыми дизелями. ",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/06/Higer-Touring-HD-550x300.jpg");
		addItem(increaseIdincreased(), "Туристическое Scania-3 ЛИАЗ", (float) 235000, "menu-1",
			"Автобус большого класса, предназначенный для междугородних туристических пассажирских перевозок – появился на свет в 2003 году. Он может похвастать: комфортабельным салоном, хорошим оснащением и дизельной «шестеркой» мощностью 400 л.с.  ",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/07/CRUIZE-tmb.jpg");
		addItem(increaseIdincreased(), "Компактный МАЗ-241", (float) 60000, "menu-3",
			"Автобус малого класса, предназначенный для работы на пригородных, междугородных и туристических маршрутах, появился на свет в конце 2010 года. Он может похвастать современным оформлением внешности, комфортабельным салоном и мощными и экономичными дизельными «четверками».",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/09/241-tmb.jpg");
		addItem(increaseIdincreased(), "Абтобус BAW Street", (float) 40000, "menu-3",
			"Автобус с лаконичным именем «Street» (заводской индекс модели – «2245») это пассажирский транспорт «малого класса» (категория «М3»), разработанный китайским автопроизводителем специально для «российских городских улиц».",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/06/Street-2245-tmb.jpg");
		addItem(increaseIdincreased(), "Городской автобус", (float) 45000, "menu-3",
			"Этот городской транспорт был представлен в сентябре 2015 года, а в первом квартале 2016-го поступил в серийное производство. Он отличается привлекательной внешностью и вместительным салоном, а в движение приводится современным турбодизельным мотором ЯМЗ-5344.",
			"https://truck.ironhorse.ru/wp-content/uploads/2016/04/vector-next-550x300.jpg");
		addItem(increaseIdincreased(), "Универсальный Hyundai County", (float) 55000, "menu-3",
			"Этот корейский автобус малого класса предназначен для городских и пригородных маршрутов. Он имеет довольно простую конструкцию с минимумом электроники – как следствие: достаточно высокую надежность и относительную простоту в плане технического обслуживания. ",
			"https://truck.ironhorse.ru/wp-content/uploads/2017/08/County-tmb.jpg");
		addItem(increaseIdincreased(), "Удлиненный ПАЗ-4234", (float) 40000, "menu-3",
			"Удлиненный (на базе модели «32053») автобус поступил на конвейерное производство в 2002 году (с тех пор неоднократно обновлялся. Машина доступна в «городской» и «пригородной» модификациях, а оснащается тремя дизельными двигателями на выбор.",
			"https://truck.ironhorse.ru/wp-content/uploads/2015/08/4234-550x300.jpg");
		addItem(increaseIdincreased(), "Полноприводный ПАЗ-3206", (float) 1.00, "menu-3",
			"Данный автобус малого класса серийно выпускается с 1995 года, а в 2015-м он пережил внешнее обновление. В арсенале автомобиля – полноприводная трансмиссия, тяговитые бензиновые двигатели и 28-местный пассажирский салон.",
			"https://truck.ironhorse.ru/wp-content/uploads/2015/08/4234-2015-550x300.jpg");

	}

	private void loadCustomer() {

		addCustomer(String.valueOf(takeDefaultIdIncreased()), "Chingis");
		addCustomer(String.valueOf(increaseIdincreased()), "Nazar");
		addCustomer(String.valueOf(increaseIdincreased()), "Arman");
		addCustomer(String.valueOf(increaseIdincreased()), "Leha");
		addCustomer(String.valueOf(increaseIdincreased()), "Nazarbaev");
		addCustomer(String.valueOf(increaseIdincreased()), "Putin");
		addCustomer(String.valueOf(increaseIdincreased()), "Sanzhar");
		addCustomer(String.valueOf(increaseIdincreased()), "Baktugul");

	}
}
