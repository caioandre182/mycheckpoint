package com.mycheckpoint.application.service;

import com.mycheckpoint.application.service.dto.FindUserEmailRequest;
import com.mycheckpoint.application.service.dto.FindUserResponse;
import com.mycheckpoint.application.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.domain.model.User;
import com.mycheckpoint.ports.in.FindUserByEmailUseCase;
import com.mycheckpoint.ports.out.UserRepository;

public class FindUserByEmailService implements FindUserByEmailUseCase {
    private final UserRepository userRepository;

    public FindUserByEmailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public FindUserResponse findByEmail(FindUserEmailRequest request){
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(UserNotFoundExcepetion::new);

        return FindUserResponse.from(user);
    }
}
