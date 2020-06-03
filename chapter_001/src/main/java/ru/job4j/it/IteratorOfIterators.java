package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators {

	Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
		return new Iterator<Integer>() {

			Iterator<Integer> iterator;

			@Override
			public boolean hasNext() {
				while (iterator == null || !iterator.hasNext() && it.hasNext()) {
					iterator = it.next();
				}
				return iterator.hasNext();
			}

			@Override
			public Integer next() {
				if (!this.hasNext()) {
					throw new NoSuchElementException();
				}
				return iterator.next();
			}
		};
	}
}
