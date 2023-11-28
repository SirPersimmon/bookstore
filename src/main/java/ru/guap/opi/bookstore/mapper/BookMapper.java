package ru.guap.opi.bookstore.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.guap.opi.bookstore.db.model.Book;
import ru.guap.opi.bookstore.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @BeanMapping(ignoreUnmappedSourceProperties = { "isbn", "author", "price" })
    BookDto bookToBookDto(Book book);

    @Mapping(target = "isbn", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "price", ignore = true)
    Book bookDtoToBook(BookDto bookDto);
}
