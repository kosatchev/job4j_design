package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {

	private final SimpleStack<T> in = new SimpleStack<>();
	private final SimpleStack<T> out = new SimpleStack<>();

	public T poll() {
		if (isOutEmpty()) {
			if (isInEmpty()) {
				throw new NoSuchElementException();
			} else {
				while (!isInEmpty()) {
					T temp = in.pop();
					out.push(temp);
				}
			}
		}
		return out.pop();
	}

	public void push(T value) {
		in.push(value);
	}

	private boolean isInEmpty() {
		return in.size() == 0;
	}

	private boolean isOutEmpty() {
		return out.size() == 0;
	}
}
