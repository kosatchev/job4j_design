package ru.job4j.tests;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author kosatchev
 */
public class UserListsJoiner {

	/**
	 * Unites Same usersin list
	 *
	 * @param users LinkedList is preferred
	 */
	public void joinSameUses(List<User> users) {
		for (int i = 0; i < users.size(); i++) {
			for (int j = i + 1; j < users.size(); j++) {
				if (users.get(i).tryJoin(users.get(j))) {
					users.remove(j);
					j--;
				}
			}
		}
	}

	/**
	 * Users list item
	 */
	public class User {

		private String name;
		private Set<String> emails = new HashSet<>();

		/**
		 * User constructor Accepts name and email addresses as a single comma
		 * separated list
		 *
		 * @param name
		 * @param emails
		 */
		public User(String name, String... emails) {
			this.name = name;
			Collections.addAll(this.emails, emails);
		}

		/**
		 * Returns user name
		 *
		 * @return
		 */
		public String getName() {
			return name;
		}

		/**
		 * Returns set of user emails
		 *
		 * @return
		 */
		public Set<String> getEmails() {
			return emails;
		}

		/**
		 * Adds all otherUser emails if one or more emails contains in both sets
		 *
		 * @param otherUser
		 * @return True if join is performed
		 */
		public boolean tryJoin(User otherUser) {
			boolean rsl = false;
			if (this.emails.removeAll(otherUser.emails)) {
				this.emails.addAll(otherUser.emails);
				rsl = true;
			}
			return rsl;
		}

		@Override
		public String toString() {
			return name + " ->" + emails.stream().collect(Collectors.joining(", "));
		}

	}
	
}
