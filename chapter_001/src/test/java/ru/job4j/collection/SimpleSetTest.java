package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

	@Test
	public void whenAddThenGet() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("first");
		String rsl = array.get(0);
		assertThat(rsl, is("first"));
	}

	@Test
	public void whenAddElevenElements() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4");
		array.add("5");
		array.add("6");
		array.add("7");
		array.add("8");
		array.add("9");
		array.add("10");
		array.add("11");
		String rsl = array.get(10);
		assertThat(rsl, is("11"));
	}

	@Test
	public void whenAddThenIt() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("1");
		String rsl = array.iterator().next();
		assertThat(rsl, is("1"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenGetEmpty() {
		SimpleArray<String> array = new SimpleArray<>();
		array.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenGetOutBound() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("1");
		array.get(1);
	}

	@Test(expected = NoSuchElementException.class)
	public void whenGetEmptyFromIt() {
		SimpleArray<String> array = new SimpleArray<>();
		array.iterator().next();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenAddOneAndGetTwoFromIt() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("1");
		Iterator<String> it = array.iterator();
		it.next();
		it.next();
	}

	@Test(expected = ConcurrentModificationException.class)
	public void whenCorruptedIt() {
		SimpleArray<String> array = new SimpleArray<>();
		array.add("1");
		Iterator<String> it = array.iterator();
		array.add("2");
		it.next();
	}

}
