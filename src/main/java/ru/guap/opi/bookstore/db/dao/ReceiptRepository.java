package ru.guap.opi.bookstore.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.guap.opi.bookstore.db.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}
