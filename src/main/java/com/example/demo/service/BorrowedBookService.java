package com.example.demo.service;

import com.example.demo.domain.BorrowedBook;

public interface BorrowedBookService {

    BorrowedBook save(BorrowedBook borrowedBook);

    BorrowedBook createBorrowedBook(String bookIsbn, Long clientId, Integer amount);
}
