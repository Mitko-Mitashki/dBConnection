package com.example.dBConnection.service;

import com.example.dBConnection.model.Book;
import com.example.dBConnection.model.Person;
import com.example.dBConnection.repository.BookRepository;
import com.example.dBConnection.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository personRepository;

    public BookServiceImpl(@Autowired BookRepository bookRepository,
                           @Autowired PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findByName(String name) {
        return bookRepository.findByName(name).get();
    }

    @Override
    public Book findByAuthor(String author) {
        return bookRepository.findByAuthor(author).get();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book likeBook(String bookName, String personName) {
        Book book = bookRepository.findByName(bookName).get();
        Person person = personRepository.findByName(personName).get();
        book.like(person);
        person.readAndLike(book);
        Book book1 = bookRepository.save(book);
        Person person1 = personRepository.save(person);
        return book1;
    }

}
