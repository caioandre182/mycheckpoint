package com.mycheckpoint.application.user.service;

import com.mycheckpoint.application.user.service.dto.UpdateUserRequest;
import com.mycheckpoint.application.user.service.exceptions.UserNotFoundExcepetion;
import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.user.domain.vo.Avatar;
import com.mycheckpoint.user.domain.vo.Bio;
import com.mycheckpoint.user.domain.vo.Username;
import com.mycheckpoint.ports.in.user.UpdateUserUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
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
