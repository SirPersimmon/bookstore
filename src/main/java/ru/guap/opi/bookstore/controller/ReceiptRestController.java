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
    public ResponseEntity<List<ReceiptDto>> list() {
        return new ResponseEntity<>(receiptService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ReceiptDto> get(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(receiptService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<ReceiptDto> add(@RequestBody ReceiptDto receiptDto) {
        return new ResponseEntity<>(receiptService.add(receiptDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ReceiptDto> update(@PathVariable("id") Integer id, @RequestBody ReceiptDto receiptDto) {
        return new ResponseEntity<>(receiptService.update(id, receiptDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ReceiptDto> delete(@PathVariable("id") Integer id) {
        receiptService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
