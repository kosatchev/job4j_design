package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analyze {

	public Info diff(List<User> previous, List<User> current) {
		Info rsl = new Info(0, 0, 0);
		Map<Integer, String> prevMap = listToMap(previous);
		Map<Integer, String> currMap = listToMap(current);

		Set<Integer> addedSet = difference(currMap.keySet(), prevMap.keySet());
		Set<Integer> deletedSet = difference(prevMap.keySet(), currMap.keySet());
		Set<Integer> intersection = intersect(prevMap.keySet(), currMap.keySet());

		for (int id : intersection) {
			if (!prevMap.get(id).equals(currMap.get(id))) {
				rsl.changed += 1;
			}
		}

		rsl.added = addedSet.size();
		rsl.deleted = deletedSet.size();
		return rsl;
	}

	public Set<Integer> difference(Set set1, Set set2) {
		Set<Integer> rsl = new HashSet(set1);
		rsl.removeAll(set2);
		return rsl;
	}

	public Set<Integer> intersect(Set set1, Set set2) {
		Set<Integer> rsl = new HashSet(set1);
		rsl.retainAll(set2);
		return rsl;
	}

	public Map<Integer, String> listToMap(List<User> usersList) {
		Map<Integer, String> rsl = new HashMap<>();
		for (User user : usersList) {
			rsl.put(user.id, user.name);
		}
		return rsl;
	}

	public static class User {

		int id;
		String name;

		public User(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}

	public static class Info {

		int added;
		int changed;
		int deleted;

		public Info(int added, int changed, int deleted) {
			this.added = added;
			this.changed = changed;
			this.deleted = deleted;
		}

		@Override
		public String toString() {
			return "Info{" + "added=" + added + ", changed=" + changed + ", deleted=" + deleted + '}';
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 59 * hash + this.added;
			hash = 59 * hash + this.changed;
			hash = 59 * hash + this.deleted;
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Info other = (Info) obj;
			if (this.added != other.added) {
				return false;
			}
			if (this.changed != other.changed) {
				return false;
			}
			if (this.deleted != other.deleted) {
				return false;
			}
			return true;
		}

	}

}
