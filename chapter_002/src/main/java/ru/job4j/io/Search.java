package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Search {

	public static void main(String[] args) {
		try {

			Path path = Paths.get(args[0]);
			
			if (!path.toFile().isDirectory()) {
				throw new IllegalArgumentException(String.format("Not directory %s", path.toAbsolutePath().toString()));
			}

			search(path, args[1]).forEach(System.out::println);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ошибка. Необходимо запускать с 2 аргументами (путь к директории и искомое расширение)");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	public static List<Path> search(Path root, String ext) {
		List<Path> rsl = new ArrayList<>();
		try {
			SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
			Files.walkFileTree(root, searcher);
			rsl = searcher.getSearchPaths();
		} catch (IOException e) {
			System.out.println(e);
		}
		return rsl;

	}
}
