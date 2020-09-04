package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

public class ReversableForwardLinkedTest {

	@Test
	public void whenAddThenIter() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
	}

	@Test
	public void whenAddAndRevertThenIter() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.revert();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
	}
	@Test
	public void whenAddThenIter2() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
	}

	@Test
	public void whenAddAndRevertThenIter2() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.revert();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(1));
	}
	@Test
	public void whenAddThenIter3() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.add(3);
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
	}

	@Test
	public void whenAddAndRevertThenIter3() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.revert();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(1));
	}
	@Test
	public void whenAddThenIter5() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.add(4);
		linked.add(5);
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
	}

	@Test
	public void whenAddAndRevertThenIter5() {
		ReversableForwardLinked<Integer> linked = new ReversableForwardLinked<>();
		linked.add(1);
		linked.add(2);
		linked.add(3);
		linked.add(4);
		linked.add(5);
		linked.revert();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(1));
	}
}
