package com.livraria.domain.user.DTO;

import com.livraria.domain.user.Role;

import java.util.List;

public record RecoveryUserDto(
        Long id,
        String username,
        List<Role> roles
) {
}
