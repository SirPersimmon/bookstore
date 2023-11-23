package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.guap.opi.bookstore.db.model.ReceiptItem;
import ru.guap.opi.bookstore.dto.ReceiptItemDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface ReceiptItemMapper {
    ReceiptItemMapper INSTANCE = Mappers.getMapper(ReceiptItemMapper.class);

    ReceiptItemDto receiptItemToReceiptItemDto(ReceiptItem receiptItem);

    ReceiptItem receiptItemDtoToReceiptItem(ReceiptItemDto receiptItemDto);
}
