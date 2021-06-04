package com.example.demo.api.rest;


import com.example.demo.data.domain.BorrowedBook;
import com.example.demo.data.domain.Client;
import com.example.demo.data.service.BorrowedBookService;
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
@Api(value = "Borrowed book API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Borrow Service"})
public class BorrowedBookRestController {

    private final BorrowedBookService borrowedBookService;


    @PostMapping(value = "/borrowedBooks")
    @ApiOperation(value = "Borrow a book")
    public BorrowedBook borrowBook(@Valid @RequestBody BorrowedBook borrowedBook) {
        log.debug("REST request to save borrowed book : {}", borrowedBook);
        borrowedBook.setId(null);
        return borrowedBookService.save(borrowedBook);
    }

    @PutMapping(value = "/borrowedBooks")
    @ApiOperation(value = "Edit a borrowed book")
    public BorrowedBook updateBorrowedBook(@Valid @RequestBody BorrowedBook borrowedBook) {
        log.debug("REST request to update borrowed book : {}", borrowedBook);
        if (borrowedBook.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return borrowedBookService.save(borrowedBook);
    }

    @GetMapping("/borrowedBooks")
    @ApiOperation(value = "Get all borrowed books")
    public List<BorrowedBook> getAllBorrowedBooks() {
        log.debug("REST request to get all borrowed books");

        return borrowedBookService.findAll();
    }

    @GetMapping("/borrowedBooks/{id}")
    @ApiOperation(value = "Get a specific borrowed book by id")
    public BorrowedBook getBorrowedBook(@PathVariable Long id) {
        log.debug("REST request to get borrowed book with id " + id);

        return borrowedBookService.findById(id);
    }

    @DeleteMapping("/borrowedBooks/{id}")
    @ApiOperation(value = "Delete a borrowed book by id")
    public String returnBorrowedBook(@PathVariable Long id) {
        log.debug("REST request to delete borrowed book with id " + id);
        borrowedBookService.deleteById(id);

        return "The borrowed book with id " + id + " deleted!";
    }

}
