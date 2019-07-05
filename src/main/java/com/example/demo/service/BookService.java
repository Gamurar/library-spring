package com.example.demo.service;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findByIsbn(String isbn);

    Book save(BookForm bookForm);

    Book save(BookForm bookForm, MultipartFile bookCover);

    void delete(BookForm bookForm);

    BookForm createBookForm(Book book);
}
