package com.mycheckpoint.ports.in.user;

import com.mycheckpoint.application.user.service.dto.LoginRequest;
import com.mycheckpoint.application.user.service.dto.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
}
