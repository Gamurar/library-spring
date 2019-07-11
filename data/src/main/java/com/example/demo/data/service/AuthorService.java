package com.example.demo.data.service;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.dto.AuthorForm;

import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author save(AuthorForm authorForm);

    List<Author> saveAll(Iterable<Author> authors);

    Author findById(Long id);

    void deleteById(Long id);

    AuthorForm createAuthorForm(Author author);
}
