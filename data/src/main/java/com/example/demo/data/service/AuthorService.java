package com.example.demo.data.service;


import com.example.demo.data.domain.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);

    List<Author> saveAll(Iterable<Author> authors);

    Author findById(Long id);

    List<Author> findAll();

    void deleteById(Long id);

}
