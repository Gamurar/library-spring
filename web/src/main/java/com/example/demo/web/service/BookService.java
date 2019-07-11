package com.example.demo.web.service;


import com.example.demo.data.domain.Book;
import com.example.demo.data.domain.dto.BookForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findByIsbn(String isbn);

    Book save(BookForm bookForm);

    Book save(BookForm bookForm, MultipartFile bookCover);

    void delete(BookForm bookForm);

    BookForm createBookForm(Book book);

    void setDefaultCover(BookForm bookForm);

    BookForm getBookForm(String isbn);
}
