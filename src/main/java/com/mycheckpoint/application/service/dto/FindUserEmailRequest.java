package com.mycheckpoint.application.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FindUserEmailRequest {
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    public String email;
}
