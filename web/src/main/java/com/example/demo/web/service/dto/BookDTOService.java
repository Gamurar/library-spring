package com.example.demo.web.service.dto;

import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.Book;
import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.AuthorDTO;
import com.example.demo.data.domain.dto.BookDTO;
import com.example.demo.data.domain.dto.PublisherDTO;
import com.example.demo.data.service.AuthorService;
import com.example.demo.data.service.BookService;
import com.example.demo.data.service.PublisherService;
import com.example.demo.web.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookDTOService {

    private final BookService bookService;
    private final AuthorService authorService;
    private final AuthorDTOService authorDTOService;
    private final PublisherService publisherService;
    private final PublisherDTOService publisherDTOService;
    private final FileService fileService;


    public BookDTO createBookForm(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setName(book.getName());
        bookDTO.setPublishYear(book.getPublishYear());
        bookDTO.setCopies(book.getCopies());
        bookDTO.setPictureName(book.getPicture());
        bookDTO.setPictureContent(fileService.convertFileToBase64(book.getPicture()));

        List<AuthorDTO> authorDTOS = new ArrayList<>();
        book.getAuthors().forEach(author -> authorDTOS.add(authorDTOService.createAuthorForm(author)));
        bookDTO.setAuthors(authorDTOS);

        PublisherDTO publisherDTO = publisherDTOService.createPublisherForm(book.getPublisher());
        bookDTO.setPublisher(publisherDTO);

        return bookDTO;
    }

    private List<Author> createAuthors(BookDTO bookDTO) {
        List<Author> authors = new ArrayList<>();
        for (AuthorDTO authorDTO : bookDTO.getAuthors()) {
            Author author = new Author();
            author.setFirstName(authorDTO.getFirstName());
            author.setLastName(authorDTO.getLastName());
            authors.add(author);
        }

        return authors;
    }

    public BookDTO getBookForm(String isbn) {
        BookDTO bookDTO;
        if (isbn == null) {
            bookDTO = new BookDTO();
        } else {
            Book book = bookService.findByIsbn(isbn);
            bookDTO = createBookForm(book);
        }

        if (bookDTO.getPictureContent() == null) {
            setDefaultCover(bookDTO);
        }
        return bookDTO;
    }

    private Book createBook(BookDTO bookDTO, List<Author> authors, Publisher publisher) {

        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setName(bookDTO.getName());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setCopies(bookDTO.getCopies());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setPicture(bookDTO.getPictureName());

        return book;
    }


    public void setDefaultCover(BookDTO bookDTO) {
        bookDTO.setPictureContent(fileService.getDefaultPictureBase64());
    }


    public Book save(BookDTO bookDTO, MultipartFile bookCover) {
        if (bookCover != null && !bookCover.getOriginalFilename().isEmpty()) {
            fileService.saveFile(bookCover);
            bookDTO.setPictureName(bookCover.getOriginalFilename());
        }

        return save(bookDTO);
    }

    public void delete(BookDTO bookDTO) {
        bookService.deleteByIsbn(bookDTO.getIsbn());
    }

    public Book save(BookDTO bookDTO) {
        log.info("Request to save book with isbn '{}'", bookDTO.getIsbn());
        List<Author> authors = createAuthors(bookDTO);
        Publisher publisher = publisherDTOService.createPublisher(bookDTO.getPublisher());

        authors = authorService.saveAll(authors);
        publisher = publisherService.save(publisher);

        Book book = createBook(bookDTO, authors, publisher);

        return bookService.save(book);
    }
}
