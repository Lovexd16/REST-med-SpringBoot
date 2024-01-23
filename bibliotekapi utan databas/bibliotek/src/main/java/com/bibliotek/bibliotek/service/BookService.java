package com.bibliotek.bibliotek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bibliotek.bibliotek.api.model.Book;

@Service
public class BookService {

    //Skapar en lista till alla böckerna
    private List<Book> bookList;

    //Hårdkodade böcker som läggs i listan
    public BookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1, "Earthsea Legend of Earthsea", "Siegfried Gierke"));
        bookList.add(new Book(2, "Shirin in Love", "Vaughn Maidens"));
        bookList.add(new Book(3, "Bill Bailey: Qualmpeddler", "Margo Laphorn"));
        bookList.add(new Book(4, "Moscow on the Hudson", "Doralynne Cattanach"));
    }

    //Metod för att skriva ut en specifik bok
    public Book getBook(Integer id) {
        return bookList.stream() //Stream ittererar igenom vår collection (bookList)
        .filter(book -> id.equals(book.getId())) //Kollar om id:t stämmer
        .findFirst() //Plockar den första i listan med det id:t, även att det inte ska finnas flera med samma id.
        .orElse(null); //Om inget hittas returneras null
    }
    
}
