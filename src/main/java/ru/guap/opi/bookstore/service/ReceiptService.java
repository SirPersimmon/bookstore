package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.ReceiptDto;

public interface ReceiptService {
    List<ReceiptDto> listAll();

    ReceiptDto findById(Integer id);

    ReceiptDto add(ReceiptDto receiptDto);

    ReceiptDto update(ReceiptDto receiptDto);

    void delete(Integer id);
}
