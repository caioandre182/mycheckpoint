package com.mycheckpoint.ports.in.user;

import com.mycheckpoint.application.user.service.dto.FindUserResponse;

public interface FindUserByIdUseCase {
    FindUserResponse findById(Long id);
}
