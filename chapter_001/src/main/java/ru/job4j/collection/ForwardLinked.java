package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

	private Node<T> head;

	public void addFirst(T value) {
		head = new Node<T>(value, this.head);
	}

	public void add(T value) {
		Node<T> node = new Node<T>(value, null);
		if (head == null) {
			head = node;
			return;
		}
		Node<T> tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = node;
	}

	public T deleteFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node<T> node = head; // помещение head в переменную для удалении ссылки next
		T rsl = node.getValue();
		head = head.next;
		node.next = null; // удаление ссылки next, для нормальной работы GC
		return rsl;
	}

	public T deleteLast() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node<T> node = head;
		if (head.next == null) {
			head = null;
		} else {
			while (node.next.next != null) {
				node = node.next;
			}
			node.next = null;
		}
		return node.value;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> node = head;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				T value = node.value;
				node = node.next;
				return value;
			}
		};
	}

	private static class Node<T> {

		T value;
		Node<T> next;
		Node<T> prev;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public T getValue() {
			return value;
		}
	}
}
