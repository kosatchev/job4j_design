package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

	private final String path;
	private final Map<String, String> values = new HashMap<String, String>();

	public Config(final String path) {
		this.path = path;
	}

	public String value(String key) {
		return values.get(key);
	}

	public void load() {
		try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
			reader
					.lines()
					.filter(l -> !l.matches("\\s*#.*"))
					.forEach(l -> {
						var keyValue = l.split("=");
						values.put(keyValue[0], keyValue.length > 1 ? keyValue[1] : null);
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringJoiner out = new StringJoiner(System.lineSeparator());
		try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
			read.lines().forEach(out::add);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Config("app.properties"));
	}
}
