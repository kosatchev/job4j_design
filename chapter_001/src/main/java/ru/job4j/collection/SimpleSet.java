package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> {

	private final SimpleArray<E> innerArray = new SimpleArray();

	public void add(E element) {
		if (contains(element)) {
			innerArray.add(element);
		}
	}

	public boolean contains(E element) {
		boolean result = false;
		for (E e : innerArray) {
			if (element.equals(e)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public Iterator<E> iterator() {
		return innerArray.iterator();
	}
}
