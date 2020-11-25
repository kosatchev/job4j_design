package ru.job4j.collection;

import java.util.ArrayList;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.List;
import ru.job4j.collection.Analyze.Info;
import ru.job4j.collection.Analyze.User;

public class AnalyzeTest {

	@Test
	public void equals() {
		Info expected = new Info(0, 0, 0);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		List<User> l2 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void added() {
		Info expected = new Info(1, 0, 0);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"));
		List<User> l2 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void deleted() {
		Info expected = new Info(0, 0, 1);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		List<User> l2 = List.of(new User(1, "a"), new User(2, "b"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void changed() {
		Info expected = new Info(0, 2, 0);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		List<User> l2 = List.of(new User(1, "a"), new User(2, "e"), new User(3, "f"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void addedChangedDeleted() {
		Info expected = new Info(1, 1, 1);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		List<User> l2 = List.of(new User(1, "a"), new User(2, "e"), new User(4, "f"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void oldEmpty() {
		Info expected = new Info(3, 0, 0);
		Analyze a = new Analyze();
		List<User> l1 = new ArrayList();
		List<User> l2 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		assertThat(a.diff(l1, l2), is(expected));
	}

	@Test
	public void newEmpty() {
		Info expected = new Info(0, 0, 3);
		Analyze a = new Analyze();
		List<User> l1 = List.of(new User(1, "a"), new User(2, "b"), new User(3, "c"));
		List<User> l2 = new ArrayList();
		assertThat(a.diff(l1, l2), is(expected));
	}

}
