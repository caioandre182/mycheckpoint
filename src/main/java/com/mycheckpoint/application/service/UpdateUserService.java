package com.mycheckpoint.application.service;

import com.mycheckpoint.application.service.dto.UpdateUserRequest;
import com.mycheckpoint.application.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.domain.model.User;
import com.mycheckpoint.domain.vo.Avatar;
import com.mycheckpoint.domain.vo.Bio;
import com.mycheckpoint.domain.vo.Username;
import com.mycheckpoint.ports.in.UpdateUserUseCase;
import com.mycheckpoint.ports.out.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateUserService implements UpdateUserUseCase {
    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(Long id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundExcepetion::new);
        if (request.getUsername() != null){
            user.setUsername(new Username(request.getUsername()));
        }

        if (request.getBio() != null){
            user.setBio(new Bio(request.getBio()));
        }

        if (request.getAvatarUrl() != null){
            user.setAvatar(new Avatar(request.getAvatarUrl()));
        }

        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

}
