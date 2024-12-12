package com.livraria.domain.Book;

import com.livraria.domain.Book.DTO.CreateBookDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @Column(length = 100, nullable = false)
    private Double stockQuantity;

    public Book(CreateBookDTO createBookDTO){
        this.name = createBookDTO.name();
        this.description = createBookDTO.description();
        this.author = createBookDTO.author();
        this.stockQuantity = createBookDTO.stockQuantity();
    }
}
