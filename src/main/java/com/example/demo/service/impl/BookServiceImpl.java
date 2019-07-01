package com.example.demo.service.impl;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;
    private AuthorService authorService;
    private PublisherService publisherService;


    @Autowired
    public BookServiceImpl(BookRepository repository,
                           AuthorService authorService,
                           PublisherService publisherService) {
        this.repository = repository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book save(BookForm bookForm) {
        Author author = createAuthor(bookForm);
        Publisher publisher = createPublisher(bookForm);

        author = authorService.save(author);
        publisher = publisherService.save(publisher);

        Book book = createBook(bookForm, author, publisher);

        return repository.save(book);
    }

    private Book createBook(BookForm bookForm, Author author, Publisher publisher) {
        Set<Author> authors = new HashSet<>();
        authors.add(author);

        Book book = new Book();
        book.setIsbn(bookForm.getIsbn());
        book.setName(bookForm.getName());
        book.setPublishYear(bookForm.getPublishYear());
        book.setCopies(bookForm.getCopies());
        book.setAuthors(authors);
        book.setPublisherId(publisher.getId());

        return book;
    }

    private Author createAuthor(BookForm bookForm) {
        Author author = new Author();
        author.setName(bookForm.getAuthor());

        return author;
    }

    private Publisher createPublisher(BookForm bookForm) {
        Publisher publisher = new Publisher();
        publisher.setName(bookForm.getPublisher());

        return publisher;
    }
}
