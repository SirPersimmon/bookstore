package ru.guap.opi.bookstore.mapper;

import org.mapstruct.Mapper;

import ru.guap.opi.bookstore.db.model.Invoice;
import ru.guap.opi.bookstore.dto.InvoiceDto;

@Mapper(componentModel = "spring", uses = { BookMapper.class })
public interface InvoiceMapper {
    InvoiceDto invoiceToInvoiceDto(Invoice invoice);

    Invoice invoiceDtoToInvoice(InvoiceDto invoiceDto);
}
