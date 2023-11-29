package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.InvoiceDto;

public interface InvoiceService {
    List<InvoiceDto> findAll();

    InvoiceDto findById(Integer id);

    InvoiceDto add(InvoiceDto invoiceDto);

    InvoiceDto update(Integer id, InvoiceDto invoiceDto);

    void delete(Integer id);
}
