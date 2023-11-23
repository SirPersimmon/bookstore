package ru.guap.opi.bookstore.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.guap.opi.bookstore.db.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
