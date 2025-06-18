package com.mycheckpoint.application.user.service;

import com.mycheckpoint.application.user.service.dto.FindUserEmailRequest;
import com.mycheckpoint.application.user.service.dto.FindUserResponse;
import com.mycheckpoint.application.user.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.ports.in.user.FindUserByEmailUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
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
