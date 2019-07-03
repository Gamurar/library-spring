package com.example.demo.service;

import com.example.demo.domain.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);

    List<Author> saveAll(Iterable<Author> authors);
}
