package com.livraria.domain.Book.DTO;

public record CreateBookDTO(String name, String description, String author, Double stockQuantity) {
}
