package com.bibliotekapi.bibliotekapi.api.model;

import jakarta.persistence.Entity;

@Entity
public class Book {
    private String title;
    private String author;
    private boolean loaned;
    private String isbn;
    
    public Book(String title, String author, boolean loaned, String isbn) {
        this.title = title;
        this.author = author;
        this.loaned = loaned;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
