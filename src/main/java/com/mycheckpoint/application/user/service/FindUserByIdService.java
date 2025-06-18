package com.mycheckpoint.application.user.service;

import com.mycheckpoint.application.user.service.dto.FindUserResponse;
import com.mycheckpoint.application.user.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.ports.in.user.FindUserByIdUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdService implements FindUserByIdUseCase {
    private final UserRepository userRepository;

    public FindUserByIdService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public FindUserResponse findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundExcepetion::new);

        return FindUserResponse.from(user);
    }
}
