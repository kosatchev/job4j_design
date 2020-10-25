package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyze {

    public static Info diff(List<User> previous, List<User> current) {
		Info rsl = new Info(0, 0, 0);
        Map<Integer, User> currMap = current.stream().collect(Collectors.toMap(user -> user.id, user -> user));
        for (User prevUser : previous) {
            if (!currMap.containsKey(prevUser.id)) {
                rsl.deleted++;
            }
            User currUser = currMap.remove(prevUser.id);
            if (currUser != null && !prevUser.name.equals(currUser.name)) {
                rsl.changed++;
            }
        }
		rsl.added = currMap.size();
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
