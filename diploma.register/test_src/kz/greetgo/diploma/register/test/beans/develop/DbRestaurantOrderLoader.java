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


	private void addItem(Integer id, String name, float price) {

		restaurantOrderTestDao.get().insertItem(id, name, price);
	}
	private void addCustomer(Integer id, String name) {

		restaurantOrderTestDao.get().insertCustomer(id, name);
	}

	private void loadItem() {

		addItem(takeDefaultIdIncreased(), "Chicken Tenders", (float) 3.50);
		addItem(increaseIdincreased(), "Chicken Tenders w/Fries", (float) 4.59);
		addItem(increaseIdincreased(), "Chicken Tenders w/Onion", (float) 5.99);
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich", (float) 2.50);
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich w/Fries", (float) 3.99);
		addItem(increaseIdincreased(), "Grilled Cheese Sandwich w/Onion", (float) 4.99);
		addItem(increaseIdincreased(), "Lettuce and Tomato Burger", (float) 1.99);
		addItem(increaseIdincreased(), "Soup", (float) 2.50);
		addItem(increaseIdincreased(), "Onion Rings", (float) 2.99);
		addItem(increaseIdincreased(), "Fires", (float) 1.99);
		addItem(increaseIdincreased(), "Sweet Potato Fries", (float) 2.49);
		addItem(increaseIdincreased(), "Sweet Tea", (float) 1.79);
		addItem(increaseIdincreased(), "Bottle Water", (float) 1.00);
		addItem(increaseIdincreased(), "Canned Drinks", (float) 1.00);
	}
	private void loadCustomer() {

		addCustomer(takeDefaultIdIncreased(), "Chingis");
		addCustomer(increaseIdincreased(), "Nazar");
		addCustomer(increaseIdincreased(), "Arman");
		addCustomer(increaseIdincreased(), "Leha");
		addCustomer(increaseIdincreased(), "Nazarbaev");
		addCustomer(increaseIdincreased(), "Putin");
		addCustomer(increaseIdincreased(), "Sanzhar");
		addCustomer(increaseIdincreased(), "Baktugul");

	}
}
