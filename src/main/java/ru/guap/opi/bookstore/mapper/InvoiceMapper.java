package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ru.guap.opi.bookstore.db.model.Invoice;
import ru.guap.opi.bookstore.dto.InvoiceDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    InvoiceDto invoiceToInvoiceDto(Invoice invoice);

    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);
}
