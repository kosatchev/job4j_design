package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class MatrixIt implements Iterator<Integer> {

	private final int[][] data;
	private int row = 0;
	private int col = 0;
	private int pos = 0;
	private int size = 0;

	public MatrixIt(int[][] data) {
		this.data = data;
		for (var row : data) {
			size += row.length;
		}

	}

	@Override
	public boolean hasNext() {
		return pos < size;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		col++;
		pos++;
		while (row < data.length && col >= data[row].length) {
			col = 0;
			row++;
		}
		return data[row][col];
	}
}
