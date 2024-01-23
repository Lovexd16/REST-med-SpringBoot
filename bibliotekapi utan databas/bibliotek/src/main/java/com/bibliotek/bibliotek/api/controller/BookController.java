package com.bibliotek.bibliotek.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Book getBook(@RequestParam UUID id) {
        System.out.println("Du visar boken med id " + id);
        return bookService.getBook(id); //Metod för att hitta rätt användare från BookService med hjälp av id
    }

    //GetMapping för att få ut alla böcker i listan
    @GetMapping("/books")
    public List<Book> getBooks() { 
        System.out.println("Du visar alla böcker");
        return bookService.getBooks(); //Metod för att visa alla böckerna från bookService
    }

    //PostMapping för att skapa och lägga till nya böcker i listan. 
    //I postman, välj POST, skriv url, i Headers välj "Content-Type" & value "application/json".
    //Välj sedan Body & raw. Sedan skapa nytt objekt med title & author i json format
    @PostMapping("/book") //Man kan ha samma route så länge det är olika mappings. Eftersom den andra mappingen med /book är en Get så är det helt ok
    public Book createBook(@RequestBody Book book) { //Ofta med Post så använder man RequestBody, då sparas all data och hela boken i ett
        System.out.println("Du lade till boken " + book);
        return bookService.createBook(book);
    }

    //DeleteMapping för att ta bort en specifik bok genom id
    //I postman, Välj DELETE, skriv URL:en med ID:t av den bok du vill ska tas bort (ex http://localhost:8080/book?id=<id på boken>)
    //Då ska boken ha tagits bort, kolla genom att köra GET http://localhost:8080/books och se om boken togs bort
    @DeleteMapping("/book")
    public Book deleteBook(@RequestParam UUID id) {
        System.out.println("Du tog bort boken med id " + id);
        return bookService.deleteBook(id);
    }

    //PatchMapping för att låna en bok
    @PatchMapping("/book/loan")
    public boolean loanBook(@RequestParam UUID id) {
        System.out.println("Du lånade boken med id " + id);
        return bookService.loanBook(id);
    }

    //PatchMapping för att lämna tillbaka en bok
    @PatchMapping("/book/return")
    public boolean returnBook(@RequestParam UUID id) {
        System.out.println("Du lämnade tillbaka boken med id " + id);
        return bookService.returnBook(id);
    }

}

