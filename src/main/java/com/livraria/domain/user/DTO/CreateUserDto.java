package com.livraria.domain.user.DTO;

import com.livraria.domain.user.UserRole;

public record CreateUserDto(
        String name,
        String username,
        String password,
        UserRole role
) {
}
