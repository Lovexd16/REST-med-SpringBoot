package com.bibliotekapi.bibliotekapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotekapi.bibliotekapi.api.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
    Book findByIsbn(String isbn);
}
