package com.kuama.kinitializer.modules.authentication.controllers;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.authentication.dtos.EmailAndPasswordDto;
import com.kuama.kinitializer.modules.authentication.dtos.JwtTokenDto;
import com.kuama.kinitializer.modules.authentication.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationService _authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        _authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> loginHandler(@RequestBody EmailAndPasswordDto emailAndPasswordDto) {

        try {
            JwtTokenDto result = _authenticationService.authenticate(emailAndPasswordDto);
            return ResponseEntity.ok(result);
        } catch (RecordNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        _authenticationService.logout(request, response);
        return ResponseEntity.ok().build();
    }

}
