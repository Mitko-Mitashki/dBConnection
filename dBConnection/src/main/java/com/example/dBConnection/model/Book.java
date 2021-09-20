package com.example.dBConnection.model;

import javax.persistence.*;
import java.util.*;


@Entity
    @Table(name = "book")
    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String author;
        private int year;

        @ManyToMany
        @JoinTable (
            name = "book_like",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
        )
        List<Person> likedByPerson = new ArrayList<>();

        public Book() {

        }

        public Book(int id, String name, String author, int year) {
            this.id = id;
            this.name = name;
            this.author = author;
            this.year = year;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<Person> getLikedByPerson() {
            return likedByPerson;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;
            Book book = (Book) o;
            return id == book.id && year == book.year && Objects.equals(name, book.name) && Objects.equals(author, book.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, author, year);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    '}';
        }

    public void like(Person person) {
            likedByPerson.add(person);

    }
}

