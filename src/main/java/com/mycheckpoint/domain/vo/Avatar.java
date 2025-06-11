package com.mycheckpoint.domain.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

import java.util.Objects;

@Embeddable
@Getter
public class Avatar {

    private String url;

    protected Avatar(){

    }

    public Avatar(String url){
        if (url != null && !url.isBlank() && !isValidUrl(url)){
            throw new IllegalArgumentException("Avatar deve ser uma URL válida (http/https)");
        }
        this.url = url != null ? url.trim() : null;
    }

    private boolean isValidUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }

    @Override
    public String toString() {
        return url != null ? url : "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avatar avatar)) return false;
        return Objects.equals(url, avatar.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
