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

import ru.guap.opi.bookstore.dto.BookDetailsDto;
import ru.guap.opi.bookstore.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(bookService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> add(@RequestBody BookDetailsDto bookDetailsDto) {
        return ResponseEntity.ok(bookService.add(bookDetailsDto));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody BookDetailsDto bookDetailsDto) {
        bookDetailsDto.setId(id);
        return ResponseEntity.ok(bookService.update(bookDetailsDto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        bookService.delete(id);
    }
}
