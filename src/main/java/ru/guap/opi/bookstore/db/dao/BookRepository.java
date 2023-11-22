package ru.guap.opi.bookstore.db.dao;

import org.springframework.data.repository.CrudRepository;

import ru.guap.opi.bookstore.db.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
