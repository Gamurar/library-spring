package com.example.demo.data.service;


import com.example.demo.data.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    Book save(Book book);

}
