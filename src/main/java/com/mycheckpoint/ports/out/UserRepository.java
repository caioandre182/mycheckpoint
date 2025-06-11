package com.mycheckpoint.ports.out;

import com.mycheckpoint.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    boolean existsByEmail(String email);
    User save(User user);
    void deleteById(Long id);

}
