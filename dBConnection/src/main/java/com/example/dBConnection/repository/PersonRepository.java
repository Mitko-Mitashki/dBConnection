package com.example.dBConnection.repository;

import com.example.dBConnection.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByName(String name);
}
