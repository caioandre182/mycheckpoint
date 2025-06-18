package com.mycheckpoint.application.user.service.exceptions;


public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("E-mail ou senha inválidos");
    }
}
