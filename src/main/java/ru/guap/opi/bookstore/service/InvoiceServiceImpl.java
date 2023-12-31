package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.guap.opi.bookstore.exception.NotFoundException;
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
    @Transactional(readOnly = true)
    public List<InvoiceDto> findAll() {
        return invoiceRepository.findAll().stream()
                .map(invoiceMapper::invoiceToInvoiceDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public InvoiceDto findById(Integer id) {
        return invoiceMapper
                .invoiceToInvoiceDto(invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    @Transactional
    public InvoiceDto add(InvoiceDto invoiceDto) {
        invoiceDto.setId(null);
        Invoice invoice = invoiceRepository.save(invoiceMapper.invoiceDtoToInvoice(invoiceDto));
        return invoiceMapper.invoiceToInvoiceDto(invoice);
    }

    @Override
    @Transactional
    public InvoiceDto update(Integer id, InvoiceDto invoiceDto) {
        if (!invoiceRepository.existsById(id)) {
            throw new NotFoundException();
        }

        invoiceDto.setId(null);
        Invoice invoice = invoiceRepository.save(invoiceMapper.invoiceDtoToInvoice(invoiceDto));
        return invoiceMapper.invoiceToInvoiceDto(invoice);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!invoiceRepository.existsById(id)) {
            throw new NotFoundException();
        }

        invoiceRepository.deleteById(id);
    }
}
