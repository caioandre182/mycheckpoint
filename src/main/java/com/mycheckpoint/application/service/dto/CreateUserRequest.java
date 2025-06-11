package com.mycheckpoint.application.service.dto;

import com.mycheckpoint.domain.vo.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    public String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    public String password;

    @NotBlank(message = "O nome de usuário é obrigatório")
    @Size(min = 3, max = 30, message = "O nome de usuário deve ter entre 3 e 30 caracteres")
    public String username;

    @NotNull(message = "O perfil (userRole) é obrigatório")
    public UserRole userRole;

    public String avatarUrl;

    @Size(max = 500, message = "A bio deve ter no máximo 500 caracteres")
    public String bio;
}
