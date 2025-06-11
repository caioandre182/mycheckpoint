package com.mycheckpoint.adapter.in.web;

import com.mycheckpoint.application.service.dto.CreateUserRequest;
import com.mycheckpoint.application.service.dto.CreateUserResponse;
import com.mycheckpoint.ports.in.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUserCase;

    public UserController(CreateUserUseCase createUserUseCase){
        this.createUserUserCase = createUserUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        CreateUserResponse response = createUserUserCase.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
