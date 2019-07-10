package com.example.demo.service.impl;

import com.example.demo.domain.Book;
import com.example.demo.domain.BorrowedBook;
import com.example.demo.domain.Client;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowedBookRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.BorrowedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowedBookServiceImpl implements BorrowedBookService {

    private final BorrowedBookRepository borrowedBookRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;

    @Override
    public BorrowedBook save(BorrowedBook borrowedBook) {
        return borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public BorrowedBook createBorrowedBook(String bookIsbn, Long clientId) {
        BorrowedBook borrowedBook = new BorrowedBook();

        Book book = bookRepository.findByIsbn(bookIsbn);
        Client client = clientRepository.findById(clientId).get();

        borrowedBook.setBook(book);
        borrowedBook.setClient(client);

        return borrowedBook;

    }

    @Override
    public List<BorrowedBook> findAll() {
        return borrowedBookRepository.findAll();
    }
}
