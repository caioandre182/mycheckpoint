package com.mycheckpoint.application.user.service;

import com.mycheckpoint.application.user.service.dto.LoginRequest;
import com.mycheckpoint.application.user.service.dto.LoginResponse;
import com.mycheckpoint.application.user.service.exceptions.InvalidCredentialsException;
import com.mycheckpoint.infrastructure.security.JwtService;
import com.mycheckpoint.ports.in.user.LoginUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
import com.mycheckpoint.user.domain.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class LoginService implements LoginUseCase {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public LoginService(UserRepository userRepository, JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(InvalidCredentialsException::new);

        if(!user.getPassword().matches(request.password)){
            throw new InvalidCredentialsException();
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}
