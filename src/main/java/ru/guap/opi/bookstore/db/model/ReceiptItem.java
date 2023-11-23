package ru.guap.opi.bookstore.db.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItem {
    private Integer lineNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Book book;

    private Integer quantity;
}
