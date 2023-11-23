package ru.guap.opi.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptItemDto {
    private Integer lineNumber;

    private BookDto book;

    private Integer quantity;
}
