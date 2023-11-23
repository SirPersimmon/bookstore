package ru.guap.opi.bookstore.db.model;

import java.math.BigDecimal;

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
public class InvoiceItem {
    private Integer lineNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Book book;

    private BigDecimal price;

    private Integer quantity;

    private BigDecimal sum;
}
