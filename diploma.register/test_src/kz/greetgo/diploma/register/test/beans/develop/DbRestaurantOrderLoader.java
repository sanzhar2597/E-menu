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

		logger.info("Start loading restaurant order...");


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

		addItem(takeDefaultIdIncreased(), "Chicken Tenders", (float) 3.50, "menu-1", "A food with a sharp taste. Often used to refer to tart or sour foods as well.", "https://thumb.chocofood.kz/gjXZEQACPKlyTzEHOkQ4GG46Ze4=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_TwCqXCK.png");
		addItem(increaseIdincreased(), "Chicken Tenders w/Fries", (float) 4.59, "menu-2", "A less harsh taste than bitterness. Couples tartness with sweetness.", "https://thumb.chocofood.kz/qlFrRFuCarUYm9s-YmaaRnIiGZA=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_4EXYdak.png");
		addItem(increaseIdincreased(), "Chicken Tenders w/Onion", (float) 5.99, "menu-1", "A bright flavor like that of lemons, limes, oranges, and other citrus fruits.", "https://thumb.chocofood.kz/eYsUZC5FBbgAOFbKjhNRHFf2B-Y=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_RecNcoD.png");
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich", (float) 2.50, "menu-3", "A light and crisp taste. Often used to describe produce or herbs.", "https://thumb.chocofood.kz/6A2HCuAKg5q37aqFrfNsWHjgZW8=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_Rm95Teg.png");
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich w/Fries", (float) 3.99, "menu-1", "A type of avocado sauce that can be prepared using mashed avocados, cream or sour cream, and other ingredients.", "https://thumb.chocofood.kz/dhCsCBrx3sIWVxnB1oZl49lFWWs=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_ZvEPwcz.png");
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich w/Onion", (float) 4.99, "menu-3", "An asian \"rice bowl dish\" consisting of avocado, tofu, okra or other ingredients simmered together and served over rice.", "https://thumb.chocofood.kz/n2iWNd6obT6c7ann6b0xH8ChrQM=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_rrTWfOM.png");
		addItem(increaseIdincreased(), "Lettuce and Tomato Burger", (float) 1.99, "menu-2", "also referred to as \"féroce d'avocat\",[13] it is prepared using mashed avocados, olive oil and lime juice, with salt cod, garlic," +
			" chili peppers, hot sauce and seasonings blended in.[14] It can be used as a spread on ", "https://thumb.chocofood.kz/w5hfwbQxlNNcLbMX2xSyqhFWVZ8=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_qotfjyM.png");
		addItem(increaseIdincreased(), "Soup", (float) 2.50, "menu-1", "Bitterness is a sensation often considered unpleasant characterized by having a sharp, pungent " +
			"taste. Unsweetened dark chocolate, caffeine, lemon rind, and some types of fruit are known to be bitter.", "https://thumb.chocofood.kz/srVT0TNF2SBHYV-z566FPabj-Fc=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_a5TLYaU.png");
		addItem(increaseIdincreased(), "Onion Rings", (float) 2.99, "menu-1", "Alu Gobi is a dry dish made with potatoes (aloo), cauliflower (gobi) and" +
			" Indian spices. It is yellowish in color, due to the use of turmeric, and occasionally contains kalonji and curry leaves. Other common ingredients include garlic, ginger, onion, coriande and occasionally contains kalonji and curry leaves. Other common ingredients include garlic, ginger, onion, coriande" +
			"r stalks, tomato, peas, and cumin. It all adds up to one of the most popular dishes ordered in Indian restaurants.", "https://thumb.chocofood.kz/1wCazZrctr0ZOc7VKLFw5Qplbzg=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_L91fsKT.png");
		addItem(increaseIdincreased(), " Fries", (float) 1.99, "menu-1", "Butter chicken is traditionally cooked in a tandoor; but may be grilled, roasted or pan-fried in less" +
			" authentic preparations. The gravy is made by first heating fresh tomato, garlic, and cardamom into a bright red pulp, which is then pureed after cooling, then the chef adds butter, Khoa and" +
			" various spices, often including asafoetida, cumin, cloves, ", "https://fort-verniy.chocofood.kz/static/img/nophoto-400x0.png?v=3");
		addItem(increaseIdincreased(), "Sweet Potato Fries", (float) 2.49, "menu-3", "Rogan josh (or roghan josh) is a staple of Kashmiri cuisine: originally it was brought to" +
			" Kashmir by the Mughals. It is one of the main dishes of the Kashmiri multi-course meal (the “Wazwan”). It consists of braised lamb chunks cooked with a gravy based on browned onions or shallots, yo" +
			"gurt, garlic, ginger and aromatic spices (cloves, bay leaves, cardamom and cinnamon).", "https://thumb.chocofood.kz/3iHbnFufG5wCIXWRHin_dax7FCY=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_DRd6pV3.png");
		addItem(increaseIdincreased(), "Sweet Tea", (float) 1.79, "menu-1", "Samosas are a fried or baked pastry with savoury filling, such as spiced potatoes, onions, peas, lentils and s" +
			"ometimes ground lamb, ground beef or ground chicken. They were introduced to India during the Muslim Delhi Sultanate when cooks from the Middle East and Central Asia migrated to work in the kitchens of th" +
			"e Sultan and the nobility. Indian samosas are usually vegetarian, and often accompanied by a mint sauce or chutney. Samosas are a common street food and many tourists or Indians eat them as a midday snack.", "https://thumb.chocofood.kz/-Y-3K4CJHYWk82_Sx458uPOQhms=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_M8ZXgFY.png");
		addItem(increaseIdincreased(), "Bottle Water", (float) 1.00, "menu-3", "Tandoori chicken a popular North Indian dish consisting of roasted chicken prepared with yogurt and spices. T" +
			"he name comes from the type of cylindrical clay oven, a tandoor, in which the dish is traditionally prepared. The chicken is marinated in yogurt and seasoned with the spice mixture tandoori masala. Cayenne pe" +
			"pper, red chili powder or Kashmiri red chili powder is used to give it a fiery red hue. This dish goes so well with steaming basmati rice and crispy naan.", "https://thumb.chocofood.kz/mHtv3b_NllmDeUwmj1oV71yQk-I=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_iN775gu.png");
		addItem(increaseIdincreased(), "Canned Drinks", (float) 1.00, "menu-2", "Naan is a leavened, oven-baked flatbread that’s normally served with all meals. Typically, it will be served hot" +
			" and brushed with ghee or butter. In non-traditional circles,", "https://thumb.chocofood.kz/P9wwq5sxJh03q2Fs9zwyP7-7kNE=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_7ajwsgW.png");
		addItem(increaseIdincreased(), "sandwich", (float) 2.99, "menu-3", "Matar Paneer is a vegetarian north Indian dish consisting of peas and farmer’s cheese (paneer) in a tomato based sauce and spiced with garam masala. ", "https://thumb.chocofood.kz/u6WjYGKF2PH63k1BkJ5NvAwCZ8w=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2013/08/28/sirnic.jpg");
		addItem(increaseIdincreased(), "bread", (float) 1.99, "menu-1", "Matar Paneer is a vegetarian north Indian dish consisting of peas and farmer’s cheese (paneer) in a tomato based sauce and spiced with garam masala. ", "https://thumb.chocofood.kz/BrQV6GOPE5LBRWfsUEVXupmoRzE=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2013/08/28/sosiski_s_grenk.jpg");
		addItem(increaseIdincreased(), "steak", (float) 2.49, "menu-2", "Matar Paneer is a vegetarian north Indian dish consisting of peas and farmer’s cheese (paneer) in a tomato based sauce and spiced with garam masala. ", "https://thumb.chocofood.kz/20PvwhhqTXIcJZX721n-8YoMfyg=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/02/05/food_cQ6KBwR.png");
		addItem(increaseIdincreased(), "tuna steak", (float) 1.79, "menu-2", "There’s nothing like the experience of stopping a Chai Wallah on the street and ordering a steaming cup of masala cha" +
			"i when in India. Made by brewing black tea with a mixture of aromatic spices and herbs. ", "https://thumb.chocofood.kz/dGf3FRfiszVfgrXqodcHkleU3Rw=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/05/14/food_oXXvLjo.png");
		addItem(increaseIdincreased(), "fish", (float) 1.00, "menu-3", "There’s nothing like the experience of stopping a Chai Wallah on the street and ordering a steaming cup of masala chai whe" +
			"n in India. Made by brewing black tea with a mixture of aromatic spices and herbs.  ", "https://thumb.chocofood.kz/x8S31dkhtdCS9jYrHEY8VsGJbug=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2014/08/07/seledka_pod_wyboi.jpg");
		addItem(increaseIdincreased(), "shrimp", (float) 1.00, "menu-2", "Tandoori chicken a popular North Indian dish consisting of roasted chicken prepared with yogurt and spices. The name come" +
			"s from the type of cylindrical clay oven, a tandoor, in which the dish is traditionally prepared. The chicken is marinated in yogurt and seasoned with the spice mixture tandoori " +
			"masala. Cayenne pepper, red chili powder or Kashmiri red chili powder is used to give it a fiery red hue. This dish goes so well with steaming basmati rice and crispy naan.","https://thumb.chocofood.kz/jsRLMwBnqlAAfj5dPGlUP4R5EzE=/fit-in/400x0/https://chocofood.kz/media/site/restaurants/food/logo/2019/02/05/food_vhsTt6r.png");
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
