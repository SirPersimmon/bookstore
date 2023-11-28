package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.guap.opi.bookstore.controller.NotFoundException;
import ru.guap.opi.bookstore.db.dao.UserRepository;
import ru.guap.opi.bookstore.db.model.User;
import ru.guap.opi.bookstore.dto.UserDto;
import ru.guap.opi.bookstore.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> listAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return userMapper
                .userToUserDto(userRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
