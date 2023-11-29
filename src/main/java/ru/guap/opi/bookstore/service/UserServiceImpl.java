package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.guap.opi.bookstore.exception.NotFoundException;
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
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Integer id) {
        return userMapper
                .userToUserDto(userRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    @Transactional
    public UserDto add(UserDto userDto) {
        userDto.setId(null);
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    @Transactional
    public UserDto update(Integer id, UserDto userDto) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }

        userDto.setId(id);
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException();
        }

        userRepository.deleteById(id);
    }
}
