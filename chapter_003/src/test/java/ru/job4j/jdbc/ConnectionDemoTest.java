package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author kosatchev
 */
public class ConnectionDemoTest {
	@Test
	public void whenLoadThenGetFile() throws Exception {
		ConnectionDemo cd = new ConnectionDemo();
		File file = new File("c:\\projects\\junior\\app.properties");
		try (FileInputStream io = new FileInputStream(file)) {
			cd.load(io);
		}
		String value = cd.getValue("home.path");
		assertThat(value, is("c:\\temp\\"));
	}
	
	@Test
	public void whenIndepPath() {
		File file = new File("./");
		for(File sub : file.listFiles()) {
			System.out.println(sub);
		}
	}
}
