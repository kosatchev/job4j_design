package ru.job4j.collection;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {

	private final Node<E> root;

	Tree(final E root) {
		this.root = new Node<>(root);
	}

	@Override
	public boolean add(E parent, E child) {
		Optional<Node<E>> e = findBy(parent);
		if (!findBy(child).isPresent() && e.isPresent()) {
			return e.get().children.add(new Node<>(child));
		} else {
			return false;
		}
	}

	private boolean addNode(Node<E> parentNode, E child) {
		if (findBy(parentNode.value).isPresent()) {
			return parentNode.children.add(new Node<>(child));
		} else {
			return false;
		}
	}

	public boolean isBinary() {
		return findByPredicate(n -> n.children.size() > 2).isEmpty();
	}

	@Override
	public Optional<Node<E>> findBy(E value) {
		return findByPredicate(n -> n.value.equals(value));
	}

	Optional<Node<E>> findByPredicate(Predicate<Node> condition) {
		Optional<Node<E>> rsl = Optional.empty();
		Queue<Node<E>> data = new LinkedList<>();
		data.offer(this.root);
		while (!data.isEmpty()) {
			Node<E> el = data.poll();
			if (condition.test(el)) {
				rsl = Optional.of(el);
				break;
			}
			data.addAll(el.children);
		}
		return rsl;
	}
}
