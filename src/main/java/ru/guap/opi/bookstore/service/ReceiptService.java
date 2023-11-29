package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.ReceiptDto;

public interface ReceiptService {
    List<ReceiptDto> findAll();

    ReceiptDto findById(Integer id);

    ReceiptDto add(ReceiptDto receiptDto);

    ReceiptDto update(Integer id, ReceiptDto receiptDto);

    void delete(Integer id);
}
