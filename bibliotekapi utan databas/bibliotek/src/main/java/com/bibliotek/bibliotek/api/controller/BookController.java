package com.bibliotek.bibliotek.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotek.bibliotek.api.model.Book;
import com.bibliotek.bibliotek.service.BookService;

@RestController
public class BookController {
    
     //Skapas för att kunna ha en connection till BookService, för att kunna kalla på metod(er) där ifrån
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //GetMapping för att få ut en specifik bok
    @GetMapping("/book")
    public Book getBook(@RequestParam Integer id) {
        return bookService.getBook(id); //Metod för att hitta rätt användare från BookService
    }

}

