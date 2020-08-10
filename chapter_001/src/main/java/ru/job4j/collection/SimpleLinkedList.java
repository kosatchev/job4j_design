package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {

	private int size = 0;
	private int modCount = 0;
	private Node<E> first = null;
	private Node<E> last = null;

	public SimpleLinkedList() {

	}

	private static class Node<E> {

		E element;
		Node<E> prev;
		Node<E> next;

		Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}

	public boolean add(E value) {
		boolean rsl = false;
		if (first == null) {
			first = new Node<>(null, value, null);
			last = first;
			rsl = true;
		} else {
			Node<E> newNode = new Node<>(last, value, null);
			last.next = newNode;
			last = newNode;
			rsl = true;
		}
		this.size++;
		modCount++;
		return rsl;
	}

	public E get(int index) {
		Objects.checkIndex(index, size);
		E rsl = null;
		if (index == 0) {
			rsl = first.element;
		} else if (index == this.size - 1) {
			rsl = last.element;
		} else {
			Node<E> nextNode = first.next;
			for (int i = 1; i <= index; i++) {
				nextNode = nextNode.next;
				rsl = nextNode.element;
			}
		}
		return rsl;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private final int expectedModCount = modCount;
			private int index = 0;
			private Node<E> actual = first;

			@Override
			public boolean hasNext() {
				checkModCount();
				return index < size;
			}

			@Override
			public E next() {
				checkModCount();
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E rsl = actual.element;
				actual = actual.next;
				index++;
				return rsl;
			}

			private void checkModCount() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}
}
