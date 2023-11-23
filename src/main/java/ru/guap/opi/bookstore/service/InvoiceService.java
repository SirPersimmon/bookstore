package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.InvoiceDto;

public interface InvoiceService {
    List<InvoiceDto> listAll();

    InvoiceDto findById(Integer id);

    InvoiceDto add(InvoiceDto invoiceDto);

    InvoiceDto update(InvoiceDto invoiceDto);

    void delete(Integer id);
}
