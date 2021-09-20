package com.example.dBConnection.controller;

import com.example.dBConnection.model.Book;
import com.example.dBConnection.model.Person;
import com.example.dBConnection.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService personService;


    public PersonController(@Autowired PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/getPersonByName")
    public ResponseEntity<Person> getPerson(@RequestParam(value = "name") String name) {
        Person person = personService.getPersonByName(name);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(path = "/addPerson")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/getAllPersons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @DeleteMapping (path = "/deletePersonById/{id}")
    public void deletePersonById(@PathVariable int id) {
        personService.deletePersonById(id);
    }

    @PutMapping( path = "/updatePersonById/{id}")
    public void updatePersonById(@PathVariable int id, @RequestBody Person person) {
        personService.updatePersonById(person, id);
    }
//
//    @GetMapping("/{personName}/book/{bookName}")
//    public ResponseEntity<Person> likeAndVote(
//            @PathVariable String personName,
//            @PathVariable String bookName
//    ) {
//        Person person = personService.likeAndVote(personName, bookName);
//        return new ResponseEntity<>(person, HttpStatus.OK);
//    }
}
