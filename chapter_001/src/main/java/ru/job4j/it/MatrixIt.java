package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {

	private final int[][] data;
	private int row = 0;
	private int col = 0;

	public MatrixIt(int[][] data) {
		this.data = data;
	}

	@Override
	public boolean hasNext() {
		while (row < data.length) {
			if (data[row].length == 0 || col == data[row].length) {
				row++;
				col = 0;
			} else if (col < data[row].length) {
				break;
			}
		}
		return row < data.length && col < data[row].length;
	}

	@Override
	public Integer next() {
		int result = 0;
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		result = data[row][col++];
		return result;
	}
}
