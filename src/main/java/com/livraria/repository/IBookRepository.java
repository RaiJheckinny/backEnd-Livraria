package com.livraria.repository;

import com.livraria.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface IBookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findById(UUID id);
}
