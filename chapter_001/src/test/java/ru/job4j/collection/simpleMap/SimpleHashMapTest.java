package ru.job4j.collection.simpleMap;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

	@Test
	public void addTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(0, "0");
		assertThat(hm.get(0), is("0"));
	}

	@Test
	public void addNullTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(0, null);
		assertNull(hm.get(0));
	}

	@Test
	public void addIndexCollisionTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(0, "0");
		hm.insert(16, "1");
		assertThat(hm.get(16), is("1"));
	}

	@Test
	public void addKeyCollisionTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(1, "0");
		hm.insert(1, "1");
		assertThat(hm.get(1), is("0"));
	}

	@Test
	public void deleteTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(0, "-");
		hm.delete(0);
		assertNull(hm.get(0));
	}

	@Test
	public void extendTest() {
		SimpleHashMap<Integer, String> hm = new SimpleHashMap<>();
		hm.insert(1, "A");
		hm.insert(2, "B");
		hm.insert(3, "C");
		hm.insert(4, "D");
		hm.insert(5, "E");
		hm.insert(6, "F");
		hm.insert(7, "G");
		hm.insert(8, "H");
		hm.insert(9, "I");
		hm.insert(10, "J");
		hm.insert(11, "K");
		hm.insert(12, "L");
		assertThat(hm.capacity(), is(32));
	}
}
