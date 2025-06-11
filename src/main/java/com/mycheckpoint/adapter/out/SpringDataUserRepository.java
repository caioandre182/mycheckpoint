package com.mycheckpoint.adapter.out;

import com.mycheckpoint.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail_Value(String email);
    boolean existsByEmail_Value(String email);
}
