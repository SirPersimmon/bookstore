package ru.guap.opi.bookstore.service;

import java.util.List;

import ru.guap.opi.bookstore.dto.UserDto;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto add(UserDto userDto);

    UserDto update(Integer id, UserDto userDto);

    void delete(Integer id);
}
