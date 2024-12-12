package com.livraria.service;

import com.livraria.domain.Book.Book;
import com.livraria.domain.Book.DTO.CreateBookDTO;
import com.livraria.domain.Book.DTO.UpdateBookDTO;
import com.livraria.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

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
    public Book editBook(UpdateBookDTO updateBookDTO, Long id) {
        Book book = getById(id);
        book.setName(updateBookDTO.name());
        book.setDescription(updateBookDTO.description());
        book.setAuthor(updateBookDTO.author());
        book.setStockQuantity(updateBookDTO.stockQuantity());
        repository.save(book);
        return book;
    }

    @Override
    public Book removeBook(Long id) {
        Book book = getById(id);
        repository.delete(book);
        return book;
    }

    @Override
    public Book getById(Long id) {
        return repository.findByUUID(id).orElseThrow(() -> new RuntimeException("Livro com o id: "+ id +" nao encontrado"));
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
}
