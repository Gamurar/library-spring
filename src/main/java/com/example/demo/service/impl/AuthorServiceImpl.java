package com.example.demo.service.impl;

import com.example.demo.domain.Author;
import com.example.demo.domain.dto.AuthorForm;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Author> saveAll(Iterable<Author> authors) {
        return repository.saveAll(authors);
    }

    @Override
    public Author findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public AuthorForm createAuthorForm(Author author) {
        AuthorForm authorForm = new AuthorForm();
        authorForm.setFirstName(author.getFirstName());
        authorForm.setLastName(author.getLastName());

        return authorForm;
    }


}
