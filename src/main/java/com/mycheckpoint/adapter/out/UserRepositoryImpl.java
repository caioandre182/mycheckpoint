package com.mycheckpoint.adapter.out;


import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.ports.out.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final SpringDataUserRepository jpaRepository;

    public UserRepositoryImpl(SpringDataUserRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findByEmail(String email){
        return jpaRepository.findByEmail_Value(email);
    }

    @Override
    public boolean existsByEmail(String email){
        return jpaRepository.existsByEmail_Value(email);
    }

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id){
        return jpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id){
        jpaRepository.deleteById(id);
    }

}
