package com.livraria.service;

import com.livraria.domain.book.DTO.CreateBookDTO;
import com.livraria.domain.book.DTO.UpdateBookDTO;
import com.livraria.domain.book.Book;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    public Book createBook(CreateBookDTO createBookDTO);
    public Book updateBook(UpdateBookDTO updateBookDTO, UUID id);
    public Book removeBook(UUID id);
    public Book getById(UUID id);
    public List<Book> getAll();
}
