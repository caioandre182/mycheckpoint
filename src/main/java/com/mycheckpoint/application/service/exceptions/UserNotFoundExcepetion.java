package com.mycheckpoint.application.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcepetion  extends RuntimeException{
    public UserNotFoundExcepetion(){
        super("Usuário não encontrado");
    }
}
