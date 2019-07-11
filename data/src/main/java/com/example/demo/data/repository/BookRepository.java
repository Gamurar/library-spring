package com.example.demo.data.repository;

import com.example.demo.data.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findAll();

    Book findByIsbn(String isbn);
}
