package ru.job4j.tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapJoiner {
	Map<String, Set<String>> first = new HashMap<>();
	Map<String, Set<String>> second = new HashMap<>();

	public MapJoiner(List<User> first, List<User> second) {
		first.stream().map(l -> this.first.put(l.getName(), l.getEmails()));
		second.stream().map(l -> this.second.put(l.getName(), l.getEmails()));
	}
	
	public boolean email
//	может, использовать стрим groupungBy
	
	
	
	public class User {
		private final String name;
		private final Set<String> emails = new HashSet<>();

		public User(String name, String ... emails) {
			this.name = name;
			Collections.addAll(this.emails, emails);
		}

		public String getName() {
			return name;
		}

		public Set<String> getEmails() {
			return emails;
		}
		
		
	}
}
