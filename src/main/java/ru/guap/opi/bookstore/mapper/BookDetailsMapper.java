package ru.guap.opi.bookstore.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ru.guap.opi.bookstore.db.model.Book;
import ru.guap.opi.bookstore.dto.BookDetailsDto;

@Mapper(componentModel = "spring")
public interface BookDetailsMapper {
    BookDetailsMapper INSTANCE = Mappers.getMapper(BookDetailsMapper.class);

    @Mapping(target = "accessDate", ignore = true)
    BookDetailsDto bookToBookDetailsDto(Book book);

    @InheritInverseConfiguration(name = "bookToBookDetailsDto")
    Book bookDetailsDtoToBook(BookDetailsDto bookDetailsDto);
}
