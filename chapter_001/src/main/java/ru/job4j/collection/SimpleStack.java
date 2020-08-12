package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {

	private int size = 0;
	private ForwardLinked<T> linked = new ForwardLinked<T>();

	public T pop() {
		T result = linked.deleteFirst();
		this.size--;
		return result;
	}

	public void push(T value) {
		linked.addFirst(value);
		this.size++;
	}

	public void poll() {
		linked.deleteLast();
		this.size--;
	}

	public int size() {
		return this.size;
	}

}
