package com.example.demo.data.service.impl;

import com.example.demo.data.domain.Book;
import com.example.demo.data.domain.BorrowedBook;
import com.example.demo.data.domain.Client;
import com.example.demo.data.repository.BookRepository;
import com.example.demo.data.repository.BorrowedBookRepository;
import com.example.demo.data.repository.ClientRepository;
import com.example.demo.data.service.BorrowedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public BorrowedBook findById(Long id) {
        return borrowedBookRepository.findById(id).get();
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            borrowedBookRepository.deleteById(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        borrowedBookRepository.deleteById(id);
    }
}
