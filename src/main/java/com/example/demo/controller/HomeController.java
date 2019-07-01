package com.example.demo.controller;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    private static final String VIEW_HOME = "home";

    private BookService bookService;


    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(path = {"/home", "/"})
    public ModelAndView showHome(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView model = new ModelAndView(VIEW_HOME);

        if (isbn != null) {
            Book book = bookService.findByIsbn(isbn);
            BookForm bookForm = createBookForm(book);
            model.addObject("book", bookForm);

            return model;
        }

        List<Book> bookList = bookService.findAll();
        model.addObject("bookList", bookList);
        model.addObject("book", new BookForm());

        return model;
    }

    @PostMapping(path = "/addBook")
    public ModelAndView addBook(@ModelAttribute("newBook") BookForm bookForm,
                                BindingResult result) {
        System.out.println("Request for saving the book is here...");
        bookService.save(bookForm);

        return showHome(null);
    }


    private BookForm createBookForm(Book book) {
        BookForm bookForm = new BookForm();
        bookForm.setIsbn(book.getIsbn());
        bookForm.setName(book.getName());
        //TODO: change to real authors
        bookForm.setAuthor("Author");
        bookForm.setPublisher(book.getPublisher() != null ? book.getPublisher().getName() : "No publisher");
        bookForm.setPublishYear(book.getPublishYear());
        bookForm.setCopies(book.getCopies());

        return bookForm;

    }


}
