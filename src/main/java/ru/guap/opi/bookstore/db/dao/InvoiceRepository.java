package ru.guap.opi.bookstore.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.guap.opi.bookstore.db.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
