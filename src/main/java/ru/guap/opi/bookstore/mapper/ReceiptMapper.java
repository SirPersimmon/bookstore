package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;

import ru.guap.opi.bookstore.db.model.Receipt;
import ru.guap.opi.bookstore.dto.ReceiptDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface ReceiptMapper {
    ReceiptDto receiptToReceiptDto(Receipt receipt);

    Receipt receiptDtoToReceipt(ReceiptDto receiptDto);
}
