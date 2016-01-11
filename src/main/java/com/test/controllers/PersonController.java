package com.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.gradle.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@RequestMapping(value = "/person/", method = RequestMethod.GET)
	public List<Person> index() {
		return new ArrayList<Person>();
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public Person get() {
		Person person = new Person("test");

		return person;
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Person create(Person person) {
		person = new Person("test");

		return person;
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	public Person update(Integer id, Person person) {
		person = new Person("test");

		return person;
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public void delete(Integer id) {

	}
}
