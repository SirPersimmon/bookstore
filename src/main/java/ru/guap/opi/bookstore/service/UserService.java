package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.UserDto;

public interface UserService {
    List<UserDto> listAll();

    UserDto findById(Integer id);

    UserDto add(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Integer id);
}
