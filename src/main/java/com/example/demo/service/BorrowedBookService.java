package com.example.demo.service;

import com.example.demo.domain.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {

    BorrowedBook save(BorrowedBook borrowedBook);

    BorrowedBook createBorrowedBook(String bookIsbn, Long clientId);

    List<BorrowedBook> findAll();
}
