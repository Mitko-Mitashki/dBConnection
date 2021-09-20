package com.example.dBConnection.controller;

import com.example.dBConnection.model.Book;
import com.example.dBConnection.model.Person;
import com.example.dBConnection.service.BookService;
import com.example.dBConnection.service.BookServiceImpl;
import com.example.dBConnection.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;


    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/test")
    public ResponseEntity<Void> test() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/addBook")
    public ResponseEntity<?> addBook (@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/findBookByName")
    public ResponseEntity<Book> findByName(@RequestParam(value = "name") String name) {
        Book book = bookService.findByName(name);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(path = "/findBookByAuthor")
    public ResponseEntity<Book> findByAuthor(@RequestParam(value = "author") String author) {
        Book book =bookService.findByAuthor(author);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(path = "/findAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @DeleteMapping(path = "/deleteBookById/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{bookName}/person/{personName}")
    public ResponseEntity<Book> likeBook(
            @PathVariable String bookName,
            @PathVariable String personName
    ) {
        Book book = bookService.likeBook(bookName, personName);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
