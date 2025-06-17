package com.mycheckpoint.application.service.dto;

import com.mycheckpoint.domain.model.User;

public class FindUserResponse {
    public Long id;
    public String email;
    public String username;
    public String avatarUrl;
    public String bio;
    public String userRole;
    public boolean emailVerified;

    public static FindUserResponse from(User user){
        FindUserResponse response = new FindUserResponse();
        response.id = user.getId();
        response.email = user.getEmail().getValue();
        response.username = user.getUsername().getValue();
        response.avatarUrl = user.getAvatar().getUrl();
        response.bio = user.getBio().getText();
        response.userRole = user.getUserRole().getValue();
        response.emailVerified = user.isEmailVerified();

        return response;
    }
}
