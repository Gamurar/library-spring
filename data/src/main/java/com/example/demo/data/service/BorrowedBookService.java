package com.example.demo.data.service;


import com.example.demo.data.domain.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {

    BorrowedBook save(BorrowedBook borrowedBook);

    BorrowedBook createBorrowedBook(String bookIsbn, Long clientId);

    List<BorrowedBook> findAll();

    void delete(long[] ids);
}
