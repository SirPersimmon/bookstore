package ru.guap.opi.bookstore.service;

import java.util.Optional;

import ru.guap.opi.bookstore.db.model.Book;

public interface BookService {
    Iterable<Book> listAll();

    Optional<Book> findById(Integer id);

    Book add(Book book);

    Book update(Book book);

    void delete(Integer id);
}
