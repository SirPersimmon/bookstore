package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.guap.opi.bookstore.db.model.InvoiceItem;
import ru.guap.opi.bookstore.dto.InvoiceItemDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface InvoiceItemMapper {
    InvoiceItemMapper INSTANCE = Mappers.getMapper(InvoiceItemMapper.class);

    InvoiceItemDto invoiceItemToInvoiceItemDto(InvoiceItem invoiceItem);

    InvoiceItem invoiceItemDtoToInvoiceItem(InvoiceItemDto invoiceItemDto);
}
