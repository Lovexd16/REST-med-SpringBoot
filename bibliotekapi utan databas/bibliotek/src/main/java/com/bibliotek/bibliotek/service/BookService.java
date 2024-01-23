package com.bibliotek.bibliotek.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bibliotek.bibliotek.api.model.Book;

@Service
public class BookService {

    //Skapar en lista till alla böckerna
    private List<Book> bookList;

    //Hårdkodade böcker som läggs i listan
    public BookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book("Earthsea Legend of Earthsea", "Siegfried Gierke", false));
        bookList.add(new Book("Shirin in Love", "Vaughn Maidens", false));
        bookList.add(new Book("Bill Bailey: Qualmpeddler", "Margo Laphorn", false));
        bookList.add(new Book("Moscow on the Hudson", "Doralynne Cattanach", true));
    }

    //Metod för att skriva ut en specifik bok
    public Book getBook(UUID id) {
        return bookList.stream() //Stream ittererar igenom vår collection (bookList)
        .filter(book -> id.equals(book.getId())) //Kollar om id:t stämmer
        .findFirst() //Plockar den första i listan med det id:t, även att det inte ska finnas flera med samma id.
        .orElse(null); //Om inget hittas returneras null
    }

    //metod för att skriva ut alla böckerna. Returnar hela listan
    public List<Book> getBooks() {
        return bookList;
    }

    //metod för att skapa ny bok
    public Book createBook(Book book) { //Tar in book från controllern
        bookList.add(book);
        return book;
    }

    //Metod för att ta bort en bok
    public Book deleteBook(UUID id) {
        Book bookToDelete = bookList.stream() //Hittar den specifika boken med ID
        .filter(book -> id.equals(book.getId()))
        .findFirst()
        .orElse(null);

        if (bookToDelete != null) { //Om boken finns tas den bort
            bookList.remove(bookToDelete);
        }

        return bookToDelete;
    }

    //Metod för att låna ut en bok
    public boolean loanBook(UUID id) {
        Book bookToLoan = getBook(id);

        if (bookToLoan != null && !bookToLoan.isLoaned()) {
            bookToLoan.setLoaned(true);
            return true;
        }

        return false;
    }

    //Metod för att lämna tillbaka en utlånad bok
    public boolean returnBook(UUID id) {
        Book bookToReturn = getBook(id);

            if (bookToReturn != null && bookToReturn.isLoaned()) {
                bookToReturn.setLoaned(false);
                return true;
            }

            return false;
        }
    }
