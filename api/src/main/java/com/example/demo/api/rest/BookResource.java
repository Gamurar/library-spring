package com.example.demo.api.rest;


import com.example.demo.data.domain.Book;
import com.example.demo.data.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookResource {

    private final BookService bookService;


    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        log.debug("REST request to save Book : {}", book);
        if (book.getIsbn() != null) {
            log.error("A new book cannot already have an ISBN");
            return null;
        }

        return bookService.save(book);
    }

    @PutMapping("/books")
    public Book updateBook(@Valid @RequestBody Book book) {
        log.debug("REST request to update Book : {}", book);
        if (book.getIsbn() == null) {
            log.error("Invalid ISBN");
            return null;
        }

        return bookService.save(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        log.debug("REST request to get all books");

        return bookService.findAll();
    }

    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        log.debug("REST request to get book with isbn " + isbn);

        return bookService.findByIsbn(isbn);
    }

    @DeleteMapping("/books/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        log.debug("REST request to delete book with isbn " + isbn);
        bookService.deleteByIsbn(isbn);

        return "The book with isbn " + isbn + " deleted!";
    }

}
