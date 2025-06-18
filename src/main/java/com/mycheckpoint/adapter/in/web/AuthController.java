package com.mycheckpoint.adapter.in.web;

import com.mycheckpoint.application.user.service.dto.LoginRequest;
import com.mycheckpoint.application.user.service.dto.LoginResponse;
import com.mycheckpoint.ports.in.user.LoginUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase){
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse response = loginUseCase.login(request);

        return ResponseEntity.ok(response);
    }
}
