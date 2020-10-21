package ru.job4j.collection;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }
	
    @Override
    public boolean add(E parent, E child) {
        if (findBy(child).isPresent()) {
            return false;
        } else {
            return findBy(parent).get().children.add(new Node<>(child));
        }
    }
	
	    private boolean addNode(Node<E> parentNode, E child) {
        return parentNode.children.add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}