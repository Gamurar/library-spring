package com.example.demo.api.rest;


import com.example.demo.data.domain.BorrowedBook;
import com.example.demo.data.domain.Client;
import com.example.demo.data.service.BorrowedBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BorrowedBookResource {

    private final BorrowedBookService borrowedBookService;


//    TODO: This shit doesn't work! Fix it!
    @PostMapping(value = "/borrowedBooks")
    public BorrowedBook borrowBook(@Valid @RequestBody BorrowedBook borrowedBook) {
        log.debug("REST request to save borrowed book : {}", borrowedBook);
        if (borrowedBook.getId() != null) {
            log.error("A new borrowed book cannot already have an ID");
            return null;
        }

        return borrowedBookService.save(borrowedBook);
    }

    @PutMapping(value = "/borrowedBooks")
    public BorrowedBook updateBorrowedBook(@Valid @RequestBody BorrowedBook borrowedBook) {
        log.debug("REST request to update borrowed book : {}", borrowedBook);
        if (borrowedBook.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return borrowedBookService.save(borrowedBook);
    }

    @GetMapping("/borrowedBooks")
    public List<BorrowedBook> getAllBorrowedBooks() {
        log.debug("REST request to get all borrowed books");

        return borrowedBookService.findAll();
    }

    @GetMapping("/borrowedBooks/{id}")
    public BorrowedBook getBorrowedBook(@PathVariable Long id) {
        log.debug("REST request to get borrowed book with id " + id);

        return borrowedBookService.findById(id);
    }

    @DeleteMapping("/borrowedBooks/{id}")
    public String returnBorrowedBook(@PathVariable Long id) {
        log.debug("REST request to delete borrowed book with id " + id);
        borrowedBookService.deleteById(id);

        return "The borrowed book with id " + id + " deleted!";
    }

}
