package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

	public static List<String> filter(List<String> file) {
		List<String> rsl = new ArrayList();
		for (String line : file) {
			String[] string = line.split(" ");
			if (string[string.length - 2].equals("404")) {
				rsl.add(line);
			}
		}
		return rsl;
	}

	public static void print(List<String> file) {
		for (String line : file) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("log-input.txt"))) {
			List<String> lines = new ArrayList<String>();
			in.lines().forEach(lines::add);

			print(filter(lines));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
