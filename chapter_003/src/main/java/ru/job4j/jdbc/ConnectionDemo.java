package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {

	public static void mains(String[] args) throws Exception {
		ClassLoader loader = ConnectionDemo.class.getClassLoader();
		Properties cfg = new Properties();
//		try (InputStream in = new FileInputStream("./chapter_003/src/main/resources/app.properties")) {
//			cfg.load(in);
//		}
		try (InputStream in = loader.getResourceAsStream("app.properties")) {
			cfg.load(in);
		}
		System.out.println(cfg.getProperty("jdbc.url"));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		ClassLoader loader = ConnectionDemo.class.getClassLoader();
		Properties cfg = new Properties();
		try (InputStream in = loader.getResourceAsStream("app.properties")) {
			cfg.load(in);
		}

		Class.forName(cfg.getProperty("jdbc.driver"));
		String url = cfg.getProperty("jdbc.url");
		String login = cfg.getProperty("jdbc.login");
		String password = cfg.getProperty("jdbc.password");

		try (Connection connection = DriverManager.getConnection(url, login, password)) {
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println(metaData.getUserName());
			System.out.println(metaData.getURL());
		}
	}

	private final Properties prs = new Properties();

	public void load(InputStream io) {
		try {
			this.prs.load(io);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return this.prs.getProperty(key);
	}
}
