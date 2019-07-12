package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Author;
import com.example.demo.data.repository.AuthorRepository;
import com.example.demo.data.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

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
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
