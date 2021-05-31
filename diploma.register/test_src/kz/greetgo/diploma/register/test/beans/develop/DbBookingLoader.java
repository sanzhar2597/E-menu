package kz.greetgo.diploma.register.test.beans.develop;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.diploma.controller.register.model.Booking;
import kz.greetgo.diploma.controller.register.model.Comments;
import kz.greetgo.diploma.controller.register.model.CommentsLike;
import kz.greetgo.diploma.controller.register.model.Table;
import kz.greetgo.diploma.register.beans.all.IdGenerator;
import kz.greetgo.diploma.register.test.dao.BookingTestDao;
import kz.greetgo.util.RND;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Bean
public class DbBookingLoader {

	public BeanGetter<BookingTestDao> bookingTestDao;

	final Logger logger = Logger.getLogger(getClass());

	public BeanGetter<IdGenerator> idGenerator;

	public void loadTestData() throws Exception {

		loadBooking();
		logger.info("FINISH");
	}

	@SuppressWarnings("SpellCheckingInspection")
	private void loadBooking() throws Exception {

		logger.info("Start loading restaurant order...");
		restaurantTable();
		booking();
		booking();
		booking();
		booking();
		addComments();
		addCommentsLike();
		logger.info("Finish loading persons");
	}


	private void booking() throws Exception {

		Table table = new Table();
		table.status = 1;
		table.name = "left";


		String id = idGenerator.get().newId();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date recordDate = sdf.parse("2021-06-05");

		Booking booking = new Booking();
		booking.bookingId = RND.plusInt(1000); ;
		booking.numberOfPeople = RND.plusInt(1000);
		booking.recordTime = new Date();
		booking.recordDateDay = "2021-05-05";
		booking.recordDateFrom = String.valueOf(DateUtils.addHours(new Date(), 0));
		booking.recordDateTo = String.valueOf(DateUtils.addHours(new Date(), 2));
		booking.tableType = table.name;
		booking.phoneNumber = "8787777777777777";
		booking.personId = bookingTestDao.get().getPersonId();
		bookingTestDao.get().insertBooking(booking);
	}

	private void restaurantTable() throws Exception {

		Table table = new Table();
		table.status = 1;

		table.name = "table-one";
		table.personNumber =14;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-two";
		table.personNumber =6;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-three";
		table.personNumber =6;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-four";
		table.personNumber =6;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-five";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-six";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-seven";
		table.personNumber =6;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-eight";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-nine";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-ten";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-eleven";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-twelve";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-thirteen";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-fourteen";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-fifteen";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-sixteen";
		table.personNumber =4;
		bookingTestDao.get().insertRestaurantTable(table);
		table.name = "table-seventeen";
		table.personNumber =6;
		bookingTestDao.get().insertRestaurantTable(table);
	}

	private void addComments() {

		Comments comments = new Comments();
		comments.personId = bookingTestDao.get().getPersonId();
		comments.messages = "Очень хорошо! Спасибо!\n" +
				"По другим автовокзалам так же будет?" +
			"Добрый день! Раньше был автобус до Чолпон-Аты . Скажите сейчас есть такой маршрут? или автобус до Бишкека" +
			"Здравствуйте.подскажите,если ребенку 3 года.мне надо покупать полный билет,чтобы у ребенка было отдельное место?есть документ об инвалидности." +
			"Старая функция была лучше было видна как автобус уходил или не продаже и какой перевозчик.. а сейчас этого нет....жаль... Верните эту функцию если возможна... " +
			"о что вы добавили ном.авт.и водителя ни как не сделали лучше. " +
			"Когда появится информация номер автобуса и фамилия водителя" +
			"Пожалуйста добавьте госномер автобуса и имя фамилия водителя на маршурут Караганда-Топар 122\n" +
				"ПОЖАЛУЙСТА " +
			"Здравствуйте.хотим перевезти немецкую овчарку взрослую автобусом в Екатеринбург. по каким документам на нее брать билет или просто детский и все.? и еще если мы купили билет на собаку и все справки у нас в порядке может ли водитель отказаться везти нас? везти будем в наморднике и на поводке.";

		comments.date = new Date();
		comments.date = new Timestamp(comments.date.getTime());

		for(Integer itemId : bookingTestDao.get().getItemId())
			{
				comments.itemId = itemId;
				bookingTestDao.get().insertComments(comments);
			}
	}

	private void addCommentsLike() {

		int i = 1;
		CommentsLike commentsLike = new CommentsLike();
		commentsLike.commentsId = 1;
		for(String personId : bookingTestDao.get().listPersonId())
			{
				commentsLike.personId = personId;
				for(int index = 1; index < 5; index++)
					{
						commentsLike.commentsId = index;
						commentsLike.liked = 1;
						commentsLike.disliked = 1;
						bookingTestDao.get().insertCommentsLike(commentsLike);
					}

			}

	}

}



