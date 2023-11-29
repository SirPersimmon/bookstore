package ru.guap.opi.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.guap.opi.bookstore.dto.InvoiceDto;
import ru.guap.opi.bookstore.service.InvoiceService;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceRestController {
    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<InvoiceDto>> list() {
        return new ResponseEntity<>(invoiceService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InvoiceDto> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(invoiceService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<InvoiceDto> add(@RequestBody InvoiceDto invoiceDto) {
        return new ResponseEntity<>(invoiceService.add(invoiceDto), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<InvoiceDto> update(@PathVariable("id") Integer id, @RequestBody InvoiceDto invoiceDto) {
        return new ResponseEntity<>(invoiceService.update(id, invoiceDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<InvoiceDto> delete(@PathVariable("id") Integer id) {
        invoiceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
