package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.BookDetailsDto;

public interface BookService {
    List<BookDetailsDto> listAll();

    BookDetailsDto findById(Integer id);

    BookDetailsDto add(BookDetailsDto bookDetailsDto);

    BookDetailsDto update(BookDetailsDto bookDetailsDto);

    void delete(Integer id);
}
