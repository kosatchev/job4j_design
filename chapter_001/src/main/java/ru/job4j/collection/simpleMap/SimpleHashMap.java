package ru.job4j.collection.simpleMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {

	private float loadFactor = 0.75f;
	private int capacity = 16;
	private int count = 0;
	private int modCount = 0;
	private Entry<K, V>[] hashTable = new Entry[capacity];

	public SimpleHashMap() {
	}

	public boolean insert(K key, V val) {
		boolean rsl = false;
		Entry<K, V> e = new Entry(key, val);
		if (count / capacity >= loadFactor) {
			extend();
		}
		if (e != null && val != null) {
			hashTable[calculateIndex(key, capacity)] = e;
			modCount++;
			count++;
		}
		return rsl;
	}

	public V get(K key) {
		V rsl = null;
		int i = calculateIndex(key, capacity);
		if (hashTable[i] != null && hashTable[i].getKey().equals(key)) {
			rsl = hashTable[i].getVal();
		}
		return rsl;
	}

	public boolean delete(K key) {
		boolean rsl = false;
		int i = calculateIndex(key, capacity);
		if (hashTable[i] != null && hashTable[i].getKey().equals(key)) {
			hashTable[calculateIndex(key, capacity)] = null;
			modCount++;
			rsl = true;
		}
		return rsl;
	}

	private int calculateIndex(Object obj, int capacity) {
		return obj.hashCode() % capacity;
	}

	private void extend() {
		int newSize = (int) (capacity * 2);
		Entry[] oldHashTable = hashTable;
		Entry[] newHashTable = new Entry[newSize];

		for (int i = 0; i < oldHashTable.length; i++) {
			if (oldHashTable[i] != null) {
				newHashTable[calculateIndex(oldHashTable[i].getKey(), newSize)] = new Entry(oldHashTable[i].getKey(), oldHashTable[i].getVal());
			}
		}
		capacity = newSize;
		hashTable = newHashTable;
	}

	private class Entry<K, V> {

		private final K key;
		private V val;

		Entry(K key, V val) {
			this.key = key;
			this.val = val;
		}

		K getKey() {
			return key;
		}

		V getVal() {
			return val;
		}
	}

	@Override
	public Iterator<V> iterator() {
		return new Iterator() {
			Entry<K, V>[] table = SimpleHashMap.this.hashTable;
			private final int expectedModCount = modCount;
			private int selected = 0;

			@Override
			public boolean hasNext() {
				checkModCount();
				return selected < table.length && hasNextNotNullValue();
			}

			@Override
			public V next() {
				checkModCount();
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return (V) table[selected++].getVal();
			}

			private boolean hasNextNotNullValue() {
				var has = false;
				for (int i = selected; i < table.length; i++) {
					if (table[i] != null) {
						has = true;
						selected = i;
						break;
					}
				}
				return has;
			}

			private void checkModCount() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
			}
		};
	}

}
