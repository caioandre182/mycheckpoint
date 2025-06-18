package com.mycheckpoint.user.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
public class Bio {
    private String text;

    protected Bio(){

    }

    public Bio(String text){
        if (text != null && text.length() > 500){
            throw new IllegalArgumentException("Bio não pode ter mais que 500 caracteres");
        }

        this.text = text != null ? text.trim() : null;
    }

    @Override
    public String toString() {
        return text != null ? text : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bio bio)) return false;
        return Objects.equals(text, bio.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
