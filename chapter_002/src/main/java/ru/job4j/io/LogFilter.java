package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
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

	public static void write(List<String> file) {
		try (PrintWriter out = new PrintWriter(
				new BufferedOutputStream(
						new FileOutputStream("log-out.txt")
				))) {
			for (String line : file) {
				out.write(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("log-input.txt"))) {
			List<String> lines = new ArrayList<String>();
			in.lines().forEach(lines::add);
			List<String> out = filter(lines);
			write(out);
			print(out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
