package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

	@Test(expected = NoSuchElementException.class)
	public void whenDeleteFirst() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.add(1);
		linked.deleteFirst();
		linked.iterator().next();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenDeleteFirstEmptyLinked() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.deleteFirst();
	}

	@Test
	public void whenMultiDeleteFirst() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.deleteFirst();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(2));
	}

	@Test(expected = NoSuchElementException.class)
	public void whenDeleteLast() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.add(1);
		linked.deleteLast();
		linked.iterator().next();
	}

	@Test(expected = NoSuchElementException.class)
	public void whenDeleteLastEmptyLinked() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.deleteLast();
	}

	@Test
	public void whenMultiDeleteLast() {
		ForwardLinked<Integer> linked = new ForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.deleteLast();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
	}
}
