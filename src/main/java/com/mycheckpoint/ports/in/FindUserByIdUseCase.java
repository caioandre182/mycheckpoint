package com.mycheckpoint.ports.in;

import com.mycheckpoint.application.service.dto.FindUserByIdResponse;
import com.mycheckpoint.domain.model.User;

import java.util.Optional;

public interface FindUserByIdUseCase {
    FindUserByIdResponse findById(Long id);
}
