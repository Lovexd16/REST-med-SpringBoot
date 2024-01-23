package com.bibliotek.bibliotek.api.model;

import java.util.UUID;

public class Book {

    private UUID id;
    private String title;
    private String author;
    
    public Book(String title, String author) {
        id = UUID.randomUUID(); //Använd UUID för att få ett random autogenererat ID. Detta gör sidan säkrare och oförutsägbar
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
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

    
}

