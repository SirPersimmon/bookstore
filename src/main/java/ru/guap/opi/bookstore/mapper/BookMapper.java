package ru.guap.opi.bookstore.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ru.guap.opi.bookstore.db.model.Book;
import ru.guap.opi.bookstore.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @BeanMapping(ignoreUnmappedSourceProperties = { "isbn", "author", "price" })
    BookDto bookToBookDto(Book book);

    @Mapping(target = "isbn", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "price", ignore = true)
    Book bookDtoToBook(BookDto bookDto);
}
