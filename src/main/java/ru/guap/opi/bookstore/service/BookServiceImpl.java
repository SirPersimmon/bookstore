package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.guap.opi.bookstore.exception.NotFoundException;
import ru.guap.opi.bookstore.db.dao.BookRepository;
import ru.guap.opi.bookstore.db.model.Book;
import ru.guap.opi.bookstore.dto.BookDetailsDto;
import ru.guap.opi.bookstore.mapper.BookDetailsMapper;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDetailsMapper bookDetailsMapper;

    public BookServiceImpl(BookRepository bookRepository, BookDetailsMapper bookDetailsMapper) {
        this.bookRepository = bookRepository;
        this.bookDetailsMapper = bookDetailsMapper;
    }

    @Override
    public List<BookDetailsDto> listAll() {
        return bookRepository.findAll().stream()
                .map(bookDetailsMapper::bookToBookDetailsDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDetailsDto findById(Integer id) {
        return bookDetailsMapper
                .bookToBookDetailsDto(bookRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public BookDetailsDto add(BookDetailsDto bookDetailsDto) {
        Book book = bookRepository.save(bookDetailsMapper.bookDetailsDtoToBook(bookDetailsDto));
        return bookDetailsMapper.bookToBookDetailsDto(book);
    }

    @Override
    public BookDetailsDto update(BookDetailsDto bookDetailsDto) {
        Book book = bookRepository.save(bookDetailsMapper.bookDetailsDtoToBook(bookDetailsDto));
        return bookDetailsMapper.bookToBookDetailsDto(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
