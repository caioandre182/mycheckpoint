package com.mycheckpoint.application.user.service;

import com.mycheckpoint.ports.in.user.DeleteUserUseCase;
import com.mycheckpoint.ports.out.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService implements DeleteUserUseCase {
    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
