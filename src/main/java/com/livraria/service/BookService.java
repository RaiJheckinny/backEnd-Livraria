package com.livraria.service;

import com.livraria.domain.book.Book;
import com.livraria.domain.book.DTO.CreateBookDTO;
import com.livraria.domain.book.DTO.UpdateBookDTO;
import com.livraria.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository repository;

    @Override
    public Book createBook(CreateBookDTO createBookDTO) {
        Book book = new Book(createBookDTO);
        book.setDatePublication(LocalDateTime.now());
        repository.save(book);
        return book;
    }

    @Override
    public Book updateBook(UpdateBookDTO updateBookDTO, UUID id) {
        Book book = getById(id);
        book.setName(updateBookDTO.name());
        book.setDescription(updateBookDTO.description());
        book.setAuthor(updateBookDTO.author());
        book.setStockQuantity(updateBookDTO.stockQuantity());
        book.setPrice(updateBookDTO.price());
        repository.save(book);
        return book;
    }

    @Override
    public Book removeBook(UUID id) {
        Book book = getById(id);
        repository.delete(book);
        return book;
    }

    @Override
    public Book getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro com o id: "+ id +" nao encontrado"));
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
}
