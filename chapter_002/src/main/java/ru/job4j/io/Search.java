package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Search {

	public static void main(String[] args) {

			if (args.length != 2) {
				throw new ArrayIndexOutOfBoundsException("Ошибка. Необходимо запускать с 2 аргументами (путь к директории и искомое расширение)");
			}

			Path path = Paths.get(args[0]);

			if (!path.toFile().isDirectory()) {
				throw new IllegalArgumentException(String.format("Not directory %s", path.toAbsolutePath().toString()));
			}

			search(path, args[1]).forEach(System.out::println);

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
