package com.mycheckpoint.user.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
public class Username {

    private String value;

    protected Username(){

    }

    public Username(String value){
        if (value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("Username não pode ser vazio");
        }
        if(value.length() < 3 || value.length() > 30){
            throw new IllegalArgumentException("Username deve conter entre 3 e 30 caracteres");
        }

        this.value = value.trim();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Username that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
