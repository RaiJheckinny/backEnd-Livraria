package com.livraria.domain.book.DTO;

public record UpdateBookDTO (String name, String description, String author, Long stockQuantity, Double price){
}
