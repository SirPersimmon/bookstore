package ru.guap.opi.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import ru.guap.opi.bookstore.security.Role;

@Getter
@Setter
public class UserDto {
    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Role role;
}
