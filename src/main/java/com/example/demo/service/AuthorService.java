package com.example.demo.service;

import com.example.demo.domain.Author;
import com.example.demo.domain.dto.AuthorForm;

import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author save(AuthorForm authorForm);

    List<Author> saveAll(Iterable<Author> authors);

    Author findById(Long id);

    void deleteById(Long id);

    AuthorForm createAuthorForm(Author author);
}
