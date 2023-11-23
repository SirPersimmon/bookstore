package ru.guap.opi.bookstore.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptDto {
    private Integer id;

    private String number;

    private LocalDateTime date;

    private Set<ReceiptItemDto> itemList;
}
