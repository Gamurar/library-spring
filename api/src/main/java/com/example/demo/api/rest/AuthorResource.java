package com.example.demo.api.rest;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.Book;
import com.example.demo.data.service.AuthorService;
import com.example.demo.data.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthorResource {

    private final AuthorService authorService;


    @PostMapping(value = "/authors")
    public Author createAuthor(@Valid @RequestBody Author author) {
        log.debug("REST request to save Author : {}", author);
        if (author.getId() != null) {
            log.error("A new author cannot already have an ID");
            return null;
        }

        return authorService.save(author);
    }

    @PutMapping(value = "/authors")
    public Author updateAuthor(@Valid @RequestBody Author author) {
        log.debug("REST request to update Author : {}", author);
        if (author.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return authorService.save(author);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        log.debug("REST request to get all authors");

        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        log.debug("REST request to get author with id " + id);

        return authorService.findById(id);
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        log.debug("REST request to delete author with id " + id);
        authorService.deleteById(id);

        return "The author with id " + id + " deleted!";
    }

}
