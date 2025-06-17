package com.mycheckpoint.ports.in;

import com.mycheckpoint.application.service.dto.UpdateUserRequest;

public interface UpdateUserUseCase {
    void updateUser(Long id, UpdateUserRequest request);
}
