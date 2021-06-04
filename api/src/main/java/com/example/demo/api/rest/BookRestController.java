package com.example.demo.api.rest;


import com.example.demo.data.domain.Book;
import com.example.demo.data.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Book API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Book Service"})
public class BookRestController {

    private final BookService bookService;


    @PostMapping("/books")
    @ApiOperation(value = "Create a new book")
    public Book createBook(@Valid @RequestBody Book book) {
        log.debug("REST request to save Book : {}", book);
        book.setIsbn(null);
        return bookService.save(book);
    }

    @PutMapping("/books")
    @ApiOperation(value = "Edit a specific book")
    public Book updateBook(@Valid @RequestBody Book book) {
        log.debug("REST request to update Book : {}", book);
        if (book.getIsbn() == null) {
            log.error("Invalid ISBN");
            return null;
        }

        return bookService.save(book);
    }

    @GetMapping("/books")
    @ApiOperation(value = "Get list of all books")
    public List<Book> getAllBooks() {
        log.debug("REST request to get all books");

        return bookService.findAll();
    }

    @GetMapping("/books/{isbn}")
    @ApiOperation(value = "Get a specific book by isbn")
    public Book getBook(@PathVariable String isbn) {
        log.debug("REST request to get book with isbn " + isbn);

        return bookService.findByIsbn(isbn);
    }

    @DeleteMapping("/books/{isbn}")
    @ApiOperation(value = "Delete a specific book by isbn")
    public String deleteBook(@PathVariable String isbn) {
        log.debug("REST request to delete book with isbn " + isbn);
        bookService.deleteByIsbn(isbn);

        return "The book with isbn " + isbn + " deleted!";
    }

}
