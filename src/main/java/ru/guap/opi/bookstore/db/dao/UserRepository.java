package ru.guap.opi.bookstore.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.guap.opi.bookstore.db.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
