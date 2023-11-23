package ru.guap.opi.bookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {
    private Integer id;

    private String number;

    private LocalDateTime date;

    private BigDecimal sum;

    private Set<InvoiceItemDto> itemList;
}
