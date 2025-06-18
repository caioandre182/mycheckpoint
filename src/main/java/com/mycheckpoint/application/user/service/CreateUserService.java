package com.mycheckpoint.application.user.service;

import com.mycheckpoint.application.user.service.dto.CreateUserRequest;
import com.mycheckpoint.application.user.service.dto.CreateUserResponse;
import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.ports.in.user.CreateUserUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
import org.springframework.stereotype.Service;


import static com.mycheckpoint.user.domain.factory.UserFactory.createNewUser;

@Service
public class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request){
        if (userRepository.existsByEmail(request.email)){
            throw new IllegalArgumentException("Email já cadastrado");
        }

        User user  = createNewUser(
                request.email,
                request.password,
                request.username,
                request.userRole,
                request.avatarUrl,
                request.bio);

        User saved = userRepository.save(user);

        return new CreateUserResponse(user.getId());
    }
}
