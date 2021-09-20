package com.example.dBConnection.service;

import com.example.dBConnection.model.Person;

import java.util.List;

public interface PersonService {
    Person getPersonByName(String name);

    void addPerson(Person person);

    List<Person> getAllPersons();

    void deletePersonById(int id);

    void updatePersonById(Person person, int id);

    Person likeAndVote(String personName, String bookName);
}
