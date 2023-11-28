package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;

import ru.guap.opi.bookstore.db.model.ReceiptItem;
import ru.guap.opi.bookstore.dto.ReceiptItemDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface ReceiptItemMapper {
    ReceiptItemDto receiptItemToReceiptItemDto(ReceiptItem receiptItem);

    ReceiptItem receiptItemDtoToReceiptItem(ReceiptItemDto receiptItemDto);
}
