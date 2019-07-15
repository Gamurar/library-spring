package com.example.demo.api.rest;


import com.example.demo.data.domain.Author;
import com.example.demo.data.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "Author API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Author Service"})
public class AuthorRestController {

    private final AuthorService authorService;

    @PostMapping(value = "/authors")
    @ApiOperation(value = "Create new author")
    public Author createAuthor(@Valid @RequestBody Author author) {
        log.debug("REST request to save Author : {}", author);
        if (author.getId() != null) {
            log.error("A new author cannot already have an ID");
            return null;
        }

        return authorService.save(author);
    }

    @PutMapping(value = "/authors")
    @ApiOperation(value = "Update information about an author")
    public Author updateAuthor(@Valid @RequestBody Author author) {
        log.debug("REST request to update Author : {}", author);
        if (author.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return authorService.save(author);
    }

    @GetMapping("/authors")
    @ApiOperation(value = "Get list of all authors in the database")
    public List<Author> getAllAuthors() {
        log.debug("REST request to get all authors");

        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    @ApiOperation(value = "Get specific author by id")
    public Author getAuthor(@ApiParam(value = "ID of the author about which to get information", required = true)
                                @PathVariable Long id) {
        log.debug("REST request to get author with id " + id);

        return authorService.findById(id);
    }

    @DeleteMapping("/authors/{id}")
    @ApiOperation(value = "Delete an author by id")
    public String deleteAuthor(@ApiParam(value = "ID of the author to be deleted", required = true)
                                   @PathVariable Long id) {
        log.debug("REST request to delete author with id " + id);
        authorService.deleteById(id);

        return "The author with id " + id + " deleted!";
    }

}
