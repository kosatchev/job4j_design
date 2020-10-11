/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.job4j.collection.simpleMap;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author kosatchev
 */
public class User {

	private String name;
	private int children;
	private Calendar birthday;

	public User(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 79 * hash + Objects.hashCode(this.name);
		hash = 79 * hash + this.children;
		hash = 79 * hash + Objects.hashCode(this.birthday);
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
		final User other = (User) obj;
		if (this.children != other.children) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.birthday, other.birthday)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User{" + "name=" + name + ", children=" + children + ", birthday=" + birthday.getTime() + '}';
	}
}
