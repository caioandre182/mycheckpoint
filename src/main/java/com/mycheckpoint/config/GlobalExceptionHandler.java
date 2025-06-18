package com.mycheckpoint.config;

import com.mycheckpoint.application.user.service.exceptions.InvalidCredentialsException;
import com.mycheckpoint.application.user.service.exceptions.UserNotFoundExcepetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundExcepetion.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundExcepetion ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
