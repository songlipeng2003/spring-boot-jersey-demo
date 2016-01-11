package org.test;

import static org.junit.Assert.assertEquals;

import org.gradle.model.Person;
import org.junit.Test;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
}
