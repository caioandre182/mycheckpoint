package com.mycheckpoint.adapter.in.web;

import com.mycheckpoint.application.user.service.dto.*;
import com.mycheckpoint.ports.in.user.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUserCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindUserByEmailUseCase findUserByEmailUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            FindUserByIdUseCase findUserByIdUseCase,
            FindUserByEmailUseCase findUserByEmailUseCase,
            DeleteUserUseCase deleteUserUseCase,
            UpdateUserUseCase updateUserUseCase){
        this.createUserUserCase = createUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.findUserByEmailUseCase = findUserByEmailUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest request){
        CreateUserResponse response = createUserUserCase.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<FindUserResponse> findUserById(@PathVariable Long id){
        FindUserResponse response = findUserByIdUseCase.findById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping("by-email")
    public ResponseEntity<FindUserResponse> findUserByEmail(@RequestBody @Valid FindUserEmailRequest request){
        FindUserResponse response = findUserByEmailUseCase.findByEmail(request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        deleteUserUseCase.deleteUser(id);

        return  ResponseEntity.noContent().build();
    }

    @PatchMapping("id/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable Long id, @RequestBody @Valid UpdateUserRequest request){
        updateUserUseCase.updateUser(id, request);
        return ResponseEntity.noContent().build();
    }
}
