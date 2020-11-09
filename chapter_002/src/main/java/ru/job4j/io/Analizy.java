package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

	public static void unavailable(String source, String target) {
		String start = null;
		String end;
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
				while (true) {
					String log = reader.readLine();
					if (log == null) {
						break;
					}
					if (start == null && (log.contains("400") || log.contains("500"))) {
						start = log.replaceFirst("\\d{3}\\s*", "");
					}
					if (start != null && (log.contains("200") || log.contains("300"))) {
						end = log.replaceFirst("\\d{3}\\s*", "");
						out.write(String.format("%s;%s\n", start, end));
						start = null;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		unavailable("server.log.txt", "unavailable.csv");
	}
}
