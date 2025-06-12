package com.mycheckpoint.application.service;

import com.mycheckpoint.application.service.dto.FindUserByIdResponse;
import com.mycheckpoint.application.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.domain.model.User;
import com.mycheckpoint.ports.in.FindUserByIdUseCase;
import com.mycheckpoint.ports.out.UserRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public class FindUserByIdService implements FindUserByIdUseCase {
    private final UserRepository userRepository;

    public FindUserByIdService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public FindUserByIdResponse findById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundExcepetion(id));

        return FindUserByIdResponse.from(user);
    }
}
