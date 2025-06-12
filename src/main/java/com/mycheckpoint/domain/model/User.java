package com.mycheckpoint.domain.model;

import com.mycheckpoint.domain.vo.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "password"))
    private Password password;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "username"))
    private Username username;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "avatar_url"))
    private Avatar avatar;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "bio"))
    private Bio bio;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastLogin;

    private boolean emailVerified;

    protected User(){
    }

    public User(Email email, Password password, Username username, UserRole userRole,
                Avatar avatar, Bio bio) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.userRole = userRole;
        this.avatar = avatar;
        this.bio = bio;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.emailVerified = false;
    }
}
