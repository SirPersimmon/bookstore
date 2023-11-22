package ru.guap.opi.bookstore.db.model;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    @NotNull
    private Integer lineNumber;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotNull
    private BigDecimal sum;
}
