package ru.job4j.collection.simpleMap;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SimpleMap {

	public static void main(String[] args) {

		Map<User, Object> map = new HashMap<>();

		Calendar date = Calendar.getInstance();
		date.set(10, 10, 10);

		User u1 = new User("n", 1, date);
		User u2 = new User("n", 1, date);

		map.put(u1, "object1");
		map.put(u2, "object2");

		map.entrySet().forEach(e -> System.out.println(e.getKey().toString() + ":" + e.getValue()));
	}
}
