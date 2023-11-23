package ru.guap.opi.bookstore.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceItemDto {
    private Integer lineNumber;

    private BookDto book;

    private Integer quantity;

    private BigDecimal price;

    private BigDecimal sum;
}
