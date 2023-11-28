package ru.guap.opi.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.guap.opi.bookstore.dto.UserDto;
import ru.guap.opi.bookstore.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<Object> add(@RequestBody UserDto userDto) {
        userDto.setId(null);
        return ResponseEntity.ok(userService.add(userDto));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        return ResponseEntity.ok(userService.update(userDto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}