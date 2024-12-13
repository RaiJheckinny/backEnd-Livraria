package com.livraria.domain.user;

import com.livraria.domain.user.UserRole;
import jakarta.persistence.*;

@Table(name = "roles")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole name;

    // Construtor padrão
    public Role() {}

    // Construtor com argumentos
    public Role(Long id, UserRole name) {
        this.id = id;
        this.name = name;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }

    // Método Builder
    public static RoleBuilder builder() {
        return new RoleBuilder();
    }

    public static class RoleBuilder {
        private Long id;
        private UserRole name;

        public RoleBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RoleBuilder name(UserRole name) {
            this.name = name;
            return this;
        }

        public Role build() {
            return new Role(id, name);
        }
    }
}
