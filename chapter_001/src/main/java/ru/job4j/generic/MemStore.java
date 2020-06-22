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
		boolean rsl = false;
		for (int i = 0; i < this.mem.size(); i ++) {
			if (this.mem.get(i).getId().equals(id)) {
				rsl = model == this.mem.set(i, model);
			}
		}
		return rsl;
	}

	@Override
	public boolean delete(String id) {
		boolean rsl = false;
		for (int i = 0; i < this.mem.size(); i ++) {
			if (this.mem.get(i).getId().equals(id)) {
				rsl = this.mem.remove(this.mem.get(i));
			}
		}
		return rsl;
	}

	@Override
	public T findById(String id) {
		T rsl = null;
		for (T item : this.mem) {
			if (item.getId().equals(id)) {
				rsl = item;
			}
		}
		return rsl;
	}
}
