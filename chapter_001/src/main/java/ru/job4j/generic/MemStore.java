package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

	private final List<T> mem = new ArrayList<>();

	@Override
	public void add(T model) {
		this.mem.add(model);
	}

	@Override
	public boolean replace(String id, T model) {
		T temp = this.mem.get(Integer.parseInt(id));
		return this.mem.set(Integer.parseInt(id), model).equals(temp);
	}

	@Override
	public boolean delete(String id) {
		T temp = this.mem.get(Integer.parseInt(id));
		return this.mem.remove(Integer.parseInt(id)).equals(temp);
	}

	@Override
	public T findById(String id) {
		return this.mem.get(Integer.parseInt(id));
	}
}
