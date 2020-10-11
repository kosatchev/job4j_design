package ru.job4j.collection.simpleMap;

public class HashTest {

	public static void main(String[] args) {
		System.out.println(binary(hash(12345678)));
		System.out.println(binary(hashTrim(12345678)));
		System.out.println(hash(12345678));
		System.out.println(hashTrim(12345678));
	}

	public static int hashTrim(Object key) {
		int h;
		return (15 & ((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)));
	}

	public static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	public static String binary(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 31; i++) {
			sb.append(num % 2 == 0 ? 0 : 1);
			sb.append((i + 1) % 8 == 0 ? " " : "");
			num /= 2;
		}
		return sb.reverse().toString();
	}

}
