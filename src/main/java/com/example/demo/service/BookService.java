package com.example.demo.service;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(BookForm bookForm);
}
