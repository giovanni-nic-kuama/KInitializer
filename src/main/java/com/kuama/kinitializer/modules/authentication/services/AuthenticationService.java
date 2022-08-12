package com.kuama.kinitializer.modules.authentication.services;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.authentication.dtos.EmailAndPasswordDto;
import com.kuama.kinitializer.modules.authentication.dtos.JwtTokenDto;
import com.kuama.kinitializer.modules.authentication.utils.JWTUtil;
import com.kuama.kinitializer.modules.users.entities.User;
import com.kuama.kinitializer.modules.users.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository _userRepository;

    private final AuthenticationManager _authManager;

    private final JWTUtil _jwtUtil;

    public AuthenticationService(UserRepository userRepository, AuthenticationManager authManager, JWTUtil jwtUtil) {
        _userRepository = userRepository;
        _authManager = authManager;
        _jwtUtil = jwtUtil;
    }

    public JwtTokenDto authenticate(EmailAndPasswordDto emailAndPasswordDto) throws RecordNotFoundException {
        Optional<User> optionalUser = _userRepository.findByEmail(emailAndPasswordDto.getEmail());

        if (optionalUser.isEmpty()) {
            throw new RecordNotFoundException("User with email" + emailAndPasswordDto.getEmail() + " not found");
        }

        UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                emailAndPasswordDto.getEmail(),
                emailAndPasswordDto.getPassword()
        );

        String token = _jwtUtil.generateToken(emailAndPasswordDto.getEmail());

        _authManager.authenticate(authInputToken);

        JwtTokenDto response = new JwtTokenDto();
        response.setToken(token);

        return response;
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        for(Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

    }

}
