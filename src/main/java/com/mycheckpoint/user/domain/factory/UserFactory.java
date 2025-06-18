package com.mycheckpoint.user.domain.factory;

import com.mycheckpoint.user.domain.model.User;
import com.mycheckpoint.user.domain.vo.*;

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
