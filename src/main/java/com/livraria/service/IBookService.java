package com.livraria.service;

import com.livraria.domain.Book.DTO.CreateBookDTO;
import com.livraria.domain.Book.DTO.UpdateBookDTO;
import com.livraria.domain.Book.Book;

import java.util.List;

public interface IBookService {
    public Book createBook(CreateBookDTO createBookDTO);
    public Book editBook(UpdateBookDTO updateBookDTO, Long id);
    public Book removeBook(Long id);
    public Book getById(Long id);
    public List<Book> getAll();
}
