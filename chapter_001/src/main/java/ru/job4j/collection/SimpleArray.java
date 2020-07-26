package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

	private int size = 0;
	private int position = 0;
	private int modCount = 0;
	private Object[] array;

	public SimpleArray() {
		array = new Object[10];
	}

	public SimpleArray(int size) {
		this.size = size;
		this.array = new Object[size];
	}

	public T get(int index) {
		Objects.checkIndex(index, this.position);
		return (T) array[index];
	}

	public void add(T model) {
		if (this.position == this.size) {
			extendArray();
		}
		this.array[position++] = model;
		this.modCount++;
	}

	private void extendArray() {
		this.size = array.length + (this.array.length / 2) + 1;
		this.array = Arrays.copyOf(this.array, this.size);
	}
	
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                checkModCount();
                return this.index < position;
            }

            @Override
            public T next() {
                checkModCount();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }

            private void checkModCount() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}