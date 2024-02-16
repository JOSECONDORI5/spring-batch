package com.josecondori.springbatch.processors;

import com.josecondori.springbatch.models.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) {
        String name = item.getName().toUpperCase();
        String lastname = item.getName().toUpperCase();

        return new Person(name, lastname, item.getDni());
    }
}
