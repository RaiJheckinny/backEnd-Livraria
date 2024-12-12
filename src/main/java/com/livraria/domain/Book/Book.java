package com.livraria.domain.Book;

import com.livraria.domain.Book.DTO.CreateBookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String description;
    @Column(length = 100, nullable = false)
    private String author;
    @Column(nullable = false)
    private LocalDateTime datePublication;
    @Column(nullable = false)
    private Long stockQuantity;
    @Column(nullable = false)
    private Double price;

    public Book(CreateBookDTO createBookDTO){
        this.name = createBookDTO.name();
        this.description = createBookDTO.description();
        this.author = createBookDTO.author();
        this.stockQuantity = createBookDTO.stockQuantity();
        this.price = createBookDTO.price();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDateTime datePublication) {
        this.datePublication = datePublication;
    }

    public Long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Book(){
    }
}
