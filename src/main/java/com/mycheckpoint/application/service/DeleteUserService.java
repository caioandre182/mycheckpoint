package com.mycheckpoint.application.service;

import com.mycheckpoint.ports.in.DeleteUserUseCase;
import com.mycheckpoint.ports.out.UserRepository;
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
