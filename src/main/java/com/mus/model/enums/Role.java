package com.mus.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("Управляющий"),
    MANAGER("Заведение"),
    CLIENT("Заказчик");

    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}

