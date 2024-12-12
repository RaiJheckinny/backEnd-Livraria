package com.livraria.domain.Book.DTO;

public record UpdateBookDTO (String name, String description, String author, Double stockQuantity, Long id){
}
