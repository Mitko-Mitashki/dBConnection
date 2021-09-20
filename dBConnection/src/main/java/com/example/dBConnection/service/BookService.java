package com.example.dBConnection.service;

import com.example.dBConnection.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    Book findByName(String name);
    Book findByAuthor(String author);
    List<Book> findAll();
    void deleteBookById(int id);
    Book likeBook(String bookName, String personName);
}
