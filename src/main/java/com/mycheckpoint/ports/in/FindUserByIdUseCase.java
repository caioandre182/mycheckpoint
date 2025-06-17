package com.mycheckpoint.ports.in;

import com.mycheckpoint.application.service.dto.FindUserResponse;

public interface FindUserByIdUseCase {
    FindUserResponse findById(Long id);
}
