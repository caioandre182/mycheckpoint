package com.mycheckpoint.domain.factory;

import com.mycheckpoint.domain.model.User;
import com.mycheckpoint.domain.vo.*;

import java.time.LocalDateTime;

public class UserFactory {

    public static User createNewUser(String email, String password, String username, UserRole userRole, String avatarUrl, String bio){
        return new User(
                new Email(email),
                Password.fromPlainText(password),
                new Username(username),
                userRole,
                new Avatar(avatarUrl),
                new Bio(bio)
        );
    }
}
