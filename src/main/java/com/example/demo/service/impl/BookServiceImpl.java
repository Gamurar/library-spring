package com.example.demo.service.impl;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.AuthorForm;
import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.dto.PublisherForm;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.FileService;
import com.example.demo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final FileService fileService;

    @Override
    public List<Book> findAll() {
        log.info("Request to find all books");
        return repository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    @Override
    public Book save(BookForm bookForm) {
        log.info("Request to save book with isbn '{}'", bookForm.getIsbn());
        List<Author> authors = createAuthors(bookForm);
        Publisher publisher = publisherService.createPublisher(bookForm.getPublisher());

        authors = authorService.saveAll(authors);
        publisher = publisherService.save(publisher);

        Book book = createBook(bookForm, authors, publisher);

        return repository.save(book);
    }

    @Override
    public Book save(BookForm bookForm, MultipartFile bookCover) {
        if (bookCover != null && !bookCover.getOriginalFilename().isEmpty()) {
            fileService.saveFile(bookCover);
            bookForm.setPictureName(bookCover.getOriginalFilename());
        }

        return save(bookForm);
    }

    @Override
    public void delete(BookForm bookForm) {
        repository.deleteById(bookForm.getIsbn());
    }

    @Override
    public BookForm createBookForm(Book book) {
        BookForm bookForm = new BookForm();
        bookForm.setIsbn(book.getIsbn());
        bookForm.setName(book.getName());
        bookForm.setPublishYear(book.getPublishYear());
        bookForm.setCopies(book.getCopies());
        bookForm.setPictureName(book.getPicture());
        bookForm.setPictureContent(fileService.convertFileToBase64(book.getPicture()));

        List<AuthorForm> authorForms = new ArrayList<>();
        book.getAuthors().forEach(author -> authorForms.add(authorService.createAuthorForm(author)));
        bookForm.setAuthors(authorForms);

        PublisherForm publisherForm = publisherService.createPublisherForm(book.getPublisher());
        bookForm.setPublisher(publisherForm);

        return bookForm;
    }

    @Override
    public void setDefaultCover(BookForm bookForm) {
        bookForm.setPictureContent(fileService.getDefaultPictureBase64());
    }

    private Book createBook(BookForm bookForm, List<Author> authors, Publisher publisher) {

        Book book = new Book();
        book.setIsbn(bookForm.getIsbn());
        book.setName(bookForm.getName());
        book.setPublishYear(bookForm.getPublishYear());
        book.setCopies(bookForm.getCopies());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setPicture(bookForm.getPictureName());

        return book;
    }

    private List<Author> createAuthors(BookForm bookForm) {
        List<Author> authors = new ArrayList<>();
        for (AuthorForm authorForm : bookForm.getAuthors()) {
            Author author = new Author();
            author.setFirstName(authorForm.getFirstName());
            author.setLastName(authorForm.getLastName());
            authors.add(author);
        }

        return authors;
    }

    public BookForm getBookForm(String isbn) {
        BookForm bookForm;
        if (isbn == null) {
            bookForm = new BookForm();
        } else {
            Book book = findByIsbn(isbn);
            bookForm = createBookForm(book);
        }

        if (bookForm.getPictureContent() == null) {
            setDefaultCover(bookForm);
        }
        return bookForm;
    }
}
