package com.livraria.domain.book.DTO;

public record CreateBookDTO(String name, String description, String author, Long stockQuantity, Double price) {
}
