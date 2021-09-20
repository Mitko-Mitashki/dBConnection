package com.example.dBConnection.service;

import com.example.dBConnection.model.Book;
import com.example.dBConnection.model.Person;
import com.example.dBConnection.repository.BookRepository;
import com.example.dBConnection.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BookRepository bookRepository;

    public PersonServiceImpl(@Autowired PersonRepository personRepository,
                             @Autowired BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Person getPersonByName(String name) {
        return personRepository.findByName(name).get();
    }

    @Override
    public void addPerson(Person person) {
        //Person person = new Person(23, "Lili");
        personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> list = new ArrayList<>();
        personRepository.findAll().stream().forEach(list::add);
        return list;
    }

    @Override
    public void deletePersonById(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePersonById(Person person, int id) {
        personRepository.save(person);
    }

    @Override
    public Person likeAndVote(String personName, String bookName) {
        Person person = personRepository.findByName(personName).get();
        Book book = bookRepository.findByName(bookName).get();
        person.readAndLike(book);
        Person person1 = personRepository.save(person);
        return person1;
    }
}

