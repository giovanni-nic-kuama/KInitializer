package com.kuama.kinitializer.modules.greeting.controllers;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingCreateDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingReadDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingUpdateDto;
import com.kuama.kinitializer.modules.greeting.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api")
public class GreetingsController {
    private final GreetingService _greetingService;

    public GreetingsController(GreetingService greetingService) {
        _greetingService = greetingService;
    }

    @GetMapping("/greetings/{id}")
    public ResponseEntity<GreetingReadDto> findById(@PathVariable Long id) {
        try {
            var entity = _greetingService.findById(id);
            return ResponseEntity.ok(entity);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @GetMapping("/greetings")
    public ResponseEntity<List<GreetingReadDto>> findAll() {
        var greetings = _greetingService.findAll();
        return ResponseEntity.ok(greetings);
    }

    @PostMapping("/greetings")
    public ResponseEntity<GreetingReadDto> create(@RequestBody GreetingCreateDto greetingCreateDto) {
        var greetings = _greetingService.crate(greetingCreateDto);
        return ResponseEntity.ok(greetings);
    }

    @PutMapping("/greetings/{id}")
    public ResponseEntity<GreetingReadDto> update(@PathVariable Long id, @RequestBody GreetingUpdateDto greetingUpdateDto) {
        try {
            var greetings = _greetingService.update(id, greetingUpdateDto);
            return ResponseEntity.ok(greetings);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/greetings/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            _greetingService.delete(id);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        return ResponseEntity.noContent().build();
    }

}
