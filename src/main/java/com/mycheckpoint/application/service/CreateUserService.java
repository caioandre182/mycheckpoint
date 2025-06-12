package com.mycheckpoint.application.service;

import com.mycheckpoint.application.service.dto.CreateUserRequest;
import com.mycheckpoint.application.service.dto.CreateUserResponse;
import com.mycheckpoint.domain.model.User;
import com.mycheckpoint.ports.in.CreateUserUseCase;
import com.mycheckpoint.ports.out.UserRepository;
import org.springframework.stereotype.Service;


import static com.mycheckpoint.domain.factory.UserFactory.createNewUser;

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
