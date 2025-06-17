package com.mycheckpoint.ports.in;

import com.mycheckpoint.application.service.dto.FindUserEmailRequest;
import com.mycheckpoint.application.service.dto.FindUserResponse;

public interface FindUserByEmailUseCase {
    FindUserResponse findByEmail(FindUserEmailRequest request);
}
