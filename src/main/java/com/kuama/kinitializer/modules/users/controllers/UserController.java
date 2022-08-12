package com.kuama.kinitializer.modules.users.controllers;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.users.dtos.UserCreateDto;
import com.kuama.kinitializer.modules.users.dtos.UserReadDto;
import com.kuama.kinitializer.modules.users.dtos.UserUpdateDto;
import com.kuama.kinitializer.modules.users.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService _userService;


    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserReadDto> findById(@PathVariable Long id) {
        try {
            var entity = _userService.findById(id);
            return ResponseEntity.ok(entity);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserReadDto>> findAll() {
        var greetings = _userService.findAll();
        return ResponseEntity.ok(greetings);
    }

    @PostMapping("/users")
    public ResponseEntity<UserReadDto> create(@RequestBody UserCreateDto userCreateDto) {
        var greetings = _userService.create(userCreateDto);
        return ResponseEntity.ok(greetings);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserReadDto> update(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto) {
        try {
            var greetings = _userService.update(id, userUpdateDto);
            return ResponseEntity.ok(greetings);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            _userService.delete(id);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        return ResponseEntity.noContent().build();
    }
}
