package com.mycheckpoint.user.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
@Getter
public class Email {

    private static final Pattern EMAIL_REGEX = Pattern.compile(
            "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    private String value;

    protected Email(){}

    public Email(String value) {
        if (value == null || !EMAIL_REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.value = value.toLowerCase();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Email email)) return false;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
