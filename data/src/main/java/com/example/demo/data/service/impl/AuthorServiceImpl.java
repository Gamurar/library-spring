package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.dto.AuthorForm;
import com.example.demo.data.repository.AuthorRepository;
import com.example.demo.data.service.AuthorService;
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
    public Author save(AuthorForm authorForm) {
        Author author = createAuthor(authorForm);

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
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AuthorForm createAuthorForm(Author author) {
        AuthorForm authorForm = new AuthorForm();
        authorForm.setId(author.getId());
        authorForm.setFirstName(author.getFirstName());
        authorForm.setLastName(author.getLastName());

        return authorForm;
    }

    private Author createAuthor(AuthorForm authorForm) {
        Author author = new Author();
        if (authorForm.getId() != -1L) {
            author.setId(authorForm.getId());
        }
        author.setFirstName(authorForm.getFirstName());
        author.setLastName(authorForm.getLastName());

        return author;
    }


}
