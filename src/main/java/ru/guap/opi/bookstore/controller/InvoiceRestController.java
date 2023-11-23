package ru.guap.opi.bookstore.controller;

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
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(invoiceService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(invoiceService.findById(id));
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> add(@RequestBody InvoiceDto invoiceDto) {
        return ResponseEntity.ok(invoiceService.add(invoiceDto));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody InvoiceDto invoiceDto) {
        invoiceDto.setId(id);
        return ResponseEntity.ok(invoiceService.update(invoiceDto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        invoiceService.delete(id);
    }
}