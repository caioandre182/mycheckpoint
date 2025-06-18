package com.mycheckpoint.user.domain.vo;

public enum UserRole {
    ADMIN,
    USER;

    public static UserRole fromString(String role) {
        try {
            return UserRole.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Role inválida: " + role);
        }
    }

    public String getValue() {
        return name();
    }
}
