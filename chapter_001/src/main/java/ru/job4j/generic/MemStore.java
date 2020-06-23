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
		boolean rsl = false;
		if (this.indexOf(id) != -1) {
			T temp = this.mem.set(this.indexOf(id), model);
			if (model.equals(temp)) {
				rsl = true;
			}
		}
		return rsl;
	}

	@Override
	public boolean delete(String id) {
		boolean rsl = false;
		if (this.indexOf(id) != -1) {
			T elementToDelete = this.mem.get(this.indexOf(id));
			T temp = this.mem.remove(this.indexOf(id));
			if (elementToDelete.equals(temp)) {
				rsl = true;
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
