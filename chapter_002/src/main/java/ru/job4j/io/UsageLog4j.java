package ru.job4j.io;
//import org.apache.log4j.LogManager; // 1. Простое логгирование 
//import org.apache.log4j.Logger; // 1. Простое логгирование 

import org.slf4j.Logger; // 2. Логгирование через адаптер
import org.slf4j.LoggerFactory; // 2. Логгирование через адаптер

public class UsageLog4j {

//	private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName()); 1. Простое логгирование 
	private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName()); // 2. Логгирование через адаптер

	public UsageLog4j() {
	}

//	public static void main(String[] args) { // 2. Логгирование через адаптер
//		LOG.trace("trace message");
//		LOG.debug("debug message");
//		LOG.info("info message");
//		LOG.warn("warn message");
//		LOG.error("error message");
//	}
	public static void main(String[] args) { // 3. Вывод переменных
		byte b = Byte.MAX_VALUE;
		short s = Short.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		long l = Long.MAX_VALUE;
		float f = Float.MAX_VALUE;
		double d = Double.MAX_VALUE;
		char c = Character.MAX_VALUE;
		boolean bool = Boolean.TRUE;

		LOG.debug("Max value of Byte is {}", b);
		LOG.debug("Max value of Short is {}", s);
		LOG.debug("Max value of Integer is {}", i);
		LOG.debug("Max value of Float is {}", f);
		LOG.debug("Max value of Double is {}", d);
		LOG.debug("Max value of Character is {}", c);
		LOG.debug("Max value of Boolean is {}", bool);
	}

}
