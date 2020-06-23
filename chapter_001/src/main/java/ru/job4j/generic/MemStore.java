package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

	private final List<T> mem = new ArrayList<>();
	
	private int indexOf(String id) {
		int rsl = -1;
		for (int i = 0; i < this.mem.size(); i ++) {
			if (this.mem.get(i).getId().equals(id)) {
				rsl = i;
			}
		}
		return rsl;
	}
	
	@Override
	public void add(T model) {
		this.mem.add(model);
	}

	@Override
	public boolean replace(String id, T model) {
		return model == this.mem.set(this.indexOf(id), model);
	}

	@Override
	public boolean delete(String id) {
		return this.mem.get(this.indexOf(id)) == this.mem.remove(this.indexOf(id));
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
