package com.mycheckpoint.ports.in.user;

import com.mycheckpoint.application.user.service.dto.FindUserEmailRequest;
import com.mycheckpoint.application.user.service.dto.FindUserResponse;

public interface FindUserByEmailUseCase {
    FindUserResponse findByEmail(FindUserEmailRequest request);
}
