package com.bibliotekapi.bibliotekapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotekapi.bibliotekapi.api.model.Book;
import com.bibliotekapi.bibliotekapi.service.BookService;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

@GetMapping("/books")
public List<Book> getBooks() {
    List<Book> books = bookService.getBooks();
    System.out.println("Number of books retrieved: " + books.size());
    return books;
}

}
