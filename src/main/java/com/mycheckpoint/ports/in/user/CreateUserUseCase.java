package com.mycheckpoint.ports.in.user;

import com.mycheckpoint.application.user.service.dto.CreateUserRequest;
import com.mycheckpoint.application.user.service.dto.CreateUserResponse;

public interface CreateUserUseCase {
    CreateUserResponse createUser(CreateUserRequest request);
}
