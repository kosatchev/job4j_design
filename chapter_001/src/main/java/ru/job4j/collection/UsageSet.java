package ru.job4j.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {

	public static void main(String[] args) {
		Set<String> strings = new HashSet<>();
		strings.add("one");
		strings.add("two");
		strings.add("three");
		strings.add("two");
		strings.addAll(List.of("one", "four", "five"));
		
		Iterator<String> it = strings.iterator();
		while (it.hasNext()) {
			System.out.println("Текущий элемент: " + it.next());
		}

//boolean remove(E e) - удаляет указанный элемент из множества, если он присутствует в нем. Метод возвращает true, если в результате вызова метода набор данных изменился, т.е. если в результате он был удален.
		strings.remove("two");
		System.out.println("Вывод в консоль после удаления...");
		for (String s : strings) {
			System.out.println("Текущий элемент: " + s);
		}
		
//boolean removeAll(Collection<?> c) - удаляет из множества все элементы, которые содержатся в переданной в метод коллекции. Метод возвращает true, если в результате работы метода исходное множество изменилось.
		strings.removeAll(List.of("two", "three"));
		System.out.println("Вывод в консоль после удаления...");
		for (String s : strings) {
			System.out.println("Текущий элемент: " + s);
		}
		
//default boolean removeIf(Predicate<? super E> filter) - метод удаляет все элементы из коллекции, которые удовлетворяют условию определенному в предикате filter(передается в виде лямбда выражения). Если в результате работы метода множество изменилось - метод возвращает true.
		strings.removeIf(s -> s.startsWith("f"));
		System.out.println("Вывод в консоль после удаления...");
		for (String s : strings) {
			System.out.println("Текущий элемент: " + s);
		}
		
//boolean contains(E e) – метод возвращает true, если множество содержит переданный в метод элемент e. Сравнение объектов выполняется с помощью метода equals().
		boolean b = strings.contains("two");
		System.out.println("Множество содержит элемент: " + b);
		
// int size() - метод возвращает целочисленное значение, и говорит нам о том, сколько элементов содержит наше множество.
		int size = strings.size();
		System.out.println("Наше множество содержит: " + size + " элемента.");
		
// default Stream<E> stream() - метод возвращает последовательный поток Stream, источником которой является наше множество. Далее этот поток мы обрабатываем методами которые определены в интерфейсе Stream.
		strings.stream()
				.filter(s -> s.length() < 5)
				.forEach(st -> System.out.println("Текущий элемент: " + st));
	}
}
