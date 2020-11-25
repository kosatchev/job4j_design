package ru.job4j.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class AnalizyTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void whenPairWithoutComment() throws IOException {
		File source = folder.newFile("server.log.txt");
		File target = folder.newFile("unavailable.csv");

		try (PrintWriter out = new PrintWriter(source)) {
			out.println("200 10:56:01" + System.lineSeparator()
					+ "200 10:57:01" + System.lineSeparator()
					+ "400 10:58:01" + System.lineSeparator()
					+ "200 10:59:01" + System.lineSeparator()
					+ "500 11:01:02" + System.lineSeparator()
					+ "200 11:02:02");
		}

		Analizy an = new Analizy();

		an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
		try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
			assertThat(reader.readLine(), is("10:58:01;10:59:01"));
			assertThat(reader.readLine(), is("11:01:02;11:02:02"));
			assertNull(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
