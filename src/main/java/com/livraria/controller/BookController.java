package com.livraria.controller;

import com.livraria.domain.Book.Book;
import com.livraria.domain.Book.DTO.CreateBookDTO;
import com.livraria.domain.Book.DTO.UpdateBookDTO;
import com.livraria.service.BookService;
import com.livraria.service.IBookService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDTO bookDTO){
        Book book = service.createBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> books = service.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Book> update(@RequestBody UpdateBookDTO bookDTO, @PathVariable UUID id){
        Book book = service.updateBook(bookDTO, id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getByUUID(@PathVariable UUID id){
        Book book = service.getById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Book> removeBook(@PathVariable UUID id){
        Book book = service.removeBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
