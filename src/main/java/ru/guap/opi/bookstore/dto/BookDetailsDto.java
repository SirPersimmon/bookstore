package ru.guap.opi.bookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDetailsDto {
    private Integer id;

    private String isbn;

    private String author;

    private String title;

    private BigDecimal price;

    private LocalDate accessDate = LocalDate.now();
}
