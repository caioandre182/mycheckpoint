package com.mycheckpoint.adapter.in.web;

import com.mycheckpoint.application.service.dto.CreateUserRequest;
import com.mycheckpoint.application.service.dto.CreateUserResponse;
import com.mycheckpoint.application.service.dto.FindUserByIdResponse;
import com.mycheckpoint.ports.in.CreateUserUseCase;
import com.mycheckpoint.ports.in.FindUserByIdUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUserCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

    public UserController(CreateUserUseCase createUserUseCase, FindUserByIdUseCase findUserByIdUseCase){
        this.createUserUserCase = createUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        CreateUserResponse response = createUserUserCase.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("id/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FindUserByIdResponse> findUserById(@PathVariable Long id){
        FindUserByIdResponse response = findUserByIdUseCase.findById(id);

        return ResponseEntity.ok(response);
    }
}
