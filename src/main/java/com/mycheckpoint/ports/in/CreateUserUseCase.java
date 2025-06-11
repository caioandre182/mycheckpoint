package com.mycheckpoint.ports.in;

import com.mycheckpoint.application.service.dto.CreateUserRequest;
import com.mycheckpoint.application.service.dto.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
}
