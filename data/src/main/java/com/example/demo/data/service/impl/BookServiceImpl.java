package com.example.demo.data.service.impl;

import com.example.demo.data.domain.Book;
import com.example.demo.data.repository.BookRepository;
import com.example.demo.data.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        log.info("Request to find all books");
        return repository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        repository.deleteById(isbn);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }


}
