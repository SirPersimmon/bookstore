package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.guap.opi.bookstore.controller.NotFoundException;
import ru.guap.opi.bookstore.db.dao.InvoiceRepository;
import ru.guap.opi.bookstore.db.model.Invoice;
import ru.guap.opi.bookstore.dto.InvoiceDto;
import ru.guap.opi.bookstore.mapper.InvoiceMapper;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceDto> listAll() {
        return invoiceRepository.findAll().stream()
                .map(invoiceMapper::invoiceToInvoiceDto)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDto findById(Integer id) {
        return invoiceMapper
                .invoiceToInvoiceDto(invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public InvoiceDto add(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceRepository.save(invoiceMapper.invoiceDtoToInvoice(invoiceDto));
        return invoiceMapper.invoiceToInvoiceDto(invoice);
    }

    @Override
    public InvoiceDto update(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceRepository.save(invoiceMapper.invoiceDtoToInvoice(invoiceDto));
        return invoiceMapper.invoiceToInvoiceDto(invoice);
    }

    @Override
    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
