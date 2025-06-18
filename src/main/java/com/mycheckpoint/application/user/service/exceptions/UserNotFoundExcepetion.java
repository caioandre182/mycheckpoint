package com.mycheckpoint.application.user.service.exceptions;

public class UserNotFoundExcepetion  extends RuntimeException{
    public UserNotFoundExcepetion(){
        super("Usuário não encontrado");
    }
}
