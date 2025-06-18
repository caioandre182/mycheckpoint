package com.mycheckpoint.ports.in.user;

import com.mycheckpoint.application.user.service.dto.UpdateUserRequest;

public interface UpdateUserUseCase {
    void updateUser(Long id, UpdateUserRequest request);
}
