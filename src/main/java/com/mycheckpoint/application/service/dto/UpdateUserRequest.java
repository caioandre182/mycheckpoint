package com.mycheckpoint.application.service.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    @Size(min = 3, max = 30, message = "O username deve ter entre 3 e 30 caracteres")
    private String username;

    @Size(max = 500, message = "A bio deve ter no máximo 500 caracteres")
    private String bio;

    @Pattern(
            regexp = "^(https?:\\/\\/)?([\\w\\-]+\\.)+[\\w\\-]+(\\/[\\w\\-._~:?#@!$&'()*+,;=]*)*$",
            message = "A URL do avatar deve ser válida (começar com http ou https)"
    )
    private String avatarUrl;

}
