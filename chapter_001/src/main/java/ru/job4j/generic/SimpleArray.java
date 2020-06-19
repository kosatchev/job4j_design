package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author kosatchev
 */
public class SimpleArray<T> implements Iterable {

	private final Object[] array;
	private int position = 0;

	public SimpleArray(int size) {
		this.array = new Object[size];
	}

	public boolean add(T value) {
		this.array[position++] = value;
		return true;
	}

	public void set(int index, T value) {
		this.array[index] = value;
	}

	public void remove(int index) {
		if (this.position - 1 - index >= 0) {
			System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
		}
	}

	public T get(int index) {
		return (T) this.array[index];
	}

	@Override
	public Iterator iterator() {
		return new Iterator<T>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < position;
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return (T) array[index++];
			}
		};
	}
}
