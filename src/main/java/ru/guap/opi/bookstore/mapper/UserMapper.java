package ru.guap.opi.bookstore.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import ru.guap.opi.bookstore.db.model.User;
import ru.guap.opi.bookstore.dto.UserDto;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Mapping(target = "password", ignore = true)
    public abstract UserDto userToUserDto(User user);

    @Mapping(target = "password", qualifiedByName = "passwordToEncodedPassword")
    public abstract User userDtoToUser(UserDto userDto);

    @Named("passwordToEncodedPassword")
    String passwordToEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
