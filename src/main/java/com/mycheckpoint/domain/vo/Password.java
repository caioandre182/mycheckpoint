package com.mycheckpoint.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

@Embeddable
@Getter
public class Password {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String value;

    protected Password() {
    }

    protected Password(String encoded) {
        this.value = encoded;
    }

    public static Password fromPlainText(String plainText) {
        if (plainText == null || plainText.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres");
        }
        return new Password(encoder.encode(plainText));
    }

    public boolean matches(String plainText) {
        return encoder.matches(plainText, this.value);
    }

    @Override
    public String toString() {
        return "********";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password password)) return false;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
