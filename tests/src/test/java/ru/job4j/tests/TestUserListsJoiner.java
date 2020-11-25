package ru.job4j.tests;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tests.UserListsJoiner.User;

public class TestUserListsJoiner {

	@Test
	public void whenSomeUsers() throws IOException {
		UserListsJoiner ulj = new UserListsJoiner();

		List<User> lu = new LinkedList<>();
		lu.add(ulj.new User("user1", "xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
		lu.add(ulj.new User("user2", "foo@gmail.com", "ups@pisem.net"));
		lu.add(ulj.new User("user3", "xyz@pisem.net", "vasya@pupkin.com"));
		lu.add(ulj.new User("user4", "ups@pisem.net", "aaa@bbb.ru"));
		lu.add(ulj.new User("user5", "xyz@pisem.net"));

		List<User> expected = new LinkedList<>();
		expected.add(ulj.new User("user1", "aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com"));
		expected.add(ulj.new User("user3", "xyz@pisem.net", "vasya@pupkin.com"));

		ulj.joinSameUses(lu);

		// Можно ли сравнить вложенные коллекции одним ассертом?
		if (expected.size() == lu.size()) {
			for (int i = 0; i < expected.size(); i++) {
				Assert.assertEquals(expected.get(i).getEmails(), lu.get(i).getEmails());
			}
		}
	}

	@Test
	public void whenAllUsers() throws IOException {
		UserListsJoiner ulj = new UserListsJoiner();

		List<User> lu = new LinkedList<>();
		lu.add(ulj.new User("user1", "xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "xyz@pisem.net"));
		lu.add(ulj.new User("user2", "foo@gmail.com", "ups@pisem.net"));
		lu.add(ulj.new User("user3", "vasya@pupkin.com", "xxx@ya.ru"));
		lu.add(ulj.new User("user4", "aaa@bbb.ru", "lol@mail.ru"));
		lu.add(ulj.new User("user5", "xyz@pisem.net"));

		List<User> expected = new LinkedList<>();
		expected.add(ulj.new User("user1", "aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com", "xyz@pisem.net", "vasya@pupkin.com"));

		ulj.joinSameUses(lu);

		// Можно ли сравнить вложенные коллекции одним ассертом?
		if (expected.size() == lu.size()) {
			for (int i = 0; i < expected.size(); i++) {
				Assert.assertEquals(expected.get(i).getEmails(), lu.get(i).getEmails());
			}
		}
	}

	@Test
	public void whenNoneUsers() throws IOException {
		UserListsJoiner ulj = new UserListsJoiner();

		List<User> lu = new LinkedList<>();
		lu.add(ulj.new User("user1", "xxx@ya.ru", "lol@mail.ru"));
		lu.add(ulj.new User("user2", "foo@gmail.com", "ups@pisem.net"));
		lu.add(ulj.new User("user3", "vasya@pupkin.com"));
		lu.add(ulj.new User("user4", "aaa@bbb.ru"));
		lu.add(ulj.new User("user5", "xyz@pisem.net"));

		List<User> expected = new LinkedList<>();
		expected.add(ulj.new User("user1", "xxx@ya.ru", "lol@mail.ru"));
		expected.add(ulj.new User("user2", "foo@gmail.com", "ups@pisem.net"));
		expected.add(ulj.new User("user3", "vasya@pupkin.com"));
		expected.add(ulj.new User("user4", "aaa@bbb.ru"));
		expected.add(ulj.new User("user5", "xyz@pisem.net"));

		ulj.joinSameUses(lu);

		// Можно ли сравнить вложенные коллекции одним ассертом?
		if (expected.size() == lu.size()) {
			for (int i = 0; i < expected.size(); i++) {
				Assert.assertEquals(expected.get(i).getEmails(), lu.get(i).getEmails());
			}
		}
	}

	@Test
	public void whenCascadeUsers() throws IOException {
		UserListsJoiner ulj = new UserListsJoiner();

		List<User> lu = new LinkedList<>();
		lu.add(ulj.new User("user1", "xxx@ya.ru", "foo@gmail.com"));
		lu.add(ulj.new User("user2", "foo@gmail.com", "ups@pisem.net"));
		lu.add(ulj.new User("user3", "ups@pisem.net", "xyz@pisem.net"));
		lu.add(ulj.new User("user4", "xyz@pisem.net", "aaa@bbb.ru"));
		lu.add(ulj.new User("user5", "aaa@bbb.ru", "lol@mail.ru"));

		List<User> expected = new LinkedList<>();
		expected.add(ulj.new User("user1", "aaa@bbb.ru", "ups@pisem.net", "lol@mail.ru", "xxx@ya.ru", "foo@gmail.com", "xyz@pisem.net"));

		ulj.joinSameUses(lu);

		// Можно ли сравнить вложенные коллекции одним ассертом?
		if (expected.size() == lu.size()) {
			for (int i = 0; i < expected.size(); i++) {
				Assert.assertEquals(expected.get(i).getEmails(), lu.get(i).getEmails());
			}
		}
	}
}
