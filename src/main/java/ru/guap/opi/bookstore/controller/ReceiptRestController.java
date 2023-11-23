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

import ru.guap.opi.bookstore.dto.ReceiptDto;
import ru.guap.opi.bookstore.service.ReceiptService;

@RestController
@RequestMapping("/api/v1/receipts")
public class ReceiptRestController {
    private final ReceiptService receiptService;

    public ReceiptRestController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(receiptService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(receiptService.findById(id));
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> add(@RequestBody ReceiptDto receiptDto) {
        return ResponseEntity.ok(receiptService.add(receiptDto));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody ReceiptDto receiptDto) {
        receiptDto.setId(id);
        return ResponseEntity.ok(receiptService.update(receiptDto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        receiptService.delete(id);
    }
}
