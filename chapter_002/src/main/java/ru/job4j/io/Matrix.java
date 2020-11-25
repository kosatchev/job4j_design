package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {

	public static void main(String[] args) {
		try (FileOutputStream out = new FileOutputStream("result.txt")) {

			out.write(matrixToString(multiple(5)).getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[][] multiple(int size) {
		int[][] table = new int[size][size];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = (i + 1) * (j + 1);
			}
		}
		return table;
	}

	public static String matrixToString(int[][] m) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				sb.append(String.format("%3d", m[i][j]));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
