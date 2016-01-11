package org.gradle.model;

import java.util.ArrayList;

public class Person {
	private final String name;

	public Person(String name) {
		this.name = name;
		new ArrayList<Person>();
	}

	public String getName() {
		return name;
	}
}
