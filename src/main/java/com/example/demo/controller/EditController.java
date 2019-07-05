package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.domain.AuthorityType;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.AuthorForm;
import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.dto.PublisherForm;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.PublisherService;
import com.example.demo.utils.Constants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

import static com.example.demo.utils.Constants.VIEW_EDIT;

@Controller
@RequestMapping("/edit")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
public class EditController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public EditController(BookService bookService,
                          AuthorService authorService,
                          PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping(path = "/book")
    public ModelAndView editBook(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView modelAndView = new ModelAndView(VIEW_EDIT);
        if (isbn == null) {
            modelAndView.addObject("book", new BookForm());
        } else {
            Book book = bookService.findByIsbn(isbn);
            BookForm bookForm = bookService.createBookForm(book);
            modelAndView.addObject("book", bookForm);
        }

        modelAndView.addObject("page", "book");
        return modelAndView;
    }

    @PostMapping(path = "/book")
    public ModelAndView addBook(@ModelAttribute("book") BookForm bookForm,
                                @RequestParam String action,
                                @RequestParam(value="book-cover", required=false) MultipartFile bookCover,
                                BindingResult result) {
        if (action.equals("save")) {
            bookService.save(bookForm, bookCover);
        }
        if (action.equals("delete")) {
            bookService.delete(bookForm);
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/author")
    public ModelAndView getAuthorEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("author", new AuthorForm());
        } else {
            Author author = authorService.findById(id);
            AuthorForm authorForm = authorService.createAuthorForm(author);
            modelAndView.addObject("author", authorForm);
        }

        modelAndView.addObject("page", "author");

        return modelAndView;
    }

    @PostMapping(path = "/author")
    public ModelAndView editAuthor(@ModelAttribute("author") AuthorForm authorForm,
                                @RequestParam String action,
                                BindingResult result) {
        if (action.equals("save")) {
            authorService.save(authorForm);
        }
        if (action.equals("delete")) {
            authorService.deleteById(authorForm.getId());
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/publisher")
    public ModelAndView getPublisherEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("publisher", new PublisherForm());
        } else {
            Publisher publisher = publisherService.findById(id);
            PublisherForm publisherForm = publisherService.createPublisherForm(publisher);
            modelAndView.addObject("publisher", publisherForm);
        }

        modelAndView.addObject("page", "publisher");

        return modelAndView;
    }

    @PostMapping(path = "/publisher")
    public ModelAndView editPublisher(@ModelAttribute("publisher") PublisherForm publisherForm,
                                   @RequestParam String action,
                                   BindingResult result) {
        if (action.equals("save")) {
            publisherService.save(publisherForm);
        }
        if (action.equals("delete")) {
            publisherService.deleteById(publisherForm.getId());
        }

        return new ModelAndView("redirect:/home");
    }
}
