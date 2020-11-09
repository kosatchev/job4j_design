package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

	@Test
	public void whenPairWithoutComment() {
		String source = "server.log.txt";
		String target = "unavailable.csv";

		Analizy an = new Analizy();
		an.unavailable(source, target);
		try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
			assertThat(reader.readLine(), is("10:58:01;10:59:01"));
			assertThat(reader.readLine(), is("11:01:02;11:02:02"));
			assertNull(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
