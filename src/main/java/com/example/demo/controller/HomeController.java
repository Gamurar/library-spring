package com.example.demo.controller;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    private static final String VIEW_HOME = "home";
    private static final String VIEW_EDIT = "edit";

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

    @GetMapping(path = "/edit")
    public ModelAndView editBook(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView modelAndView = new ModelAndView(VIEW_EDIT);
        if (isbn == null) {
            modelAndView.addObject("book", new BookForm());
        } else {
            Book book = bookService.findByIsbn(isbn);
            BookForm bookForm = createBookForm(book);
            modelAndView.addObject("book", bookForm);
        }

        return modelAndView;
    }

    @PostMapping(path = "/submit")
    public ModelAndView addBook(@ModelAttribute("newBook") BookForm bookForm,
                                @RequestParam String action,
                                BindingResult result) {
        if (action.equals("save")) {
            bookService.save(bookForm);
        }
        if (action.equals("delete")) {
            bookService.delete(bookForm);
        }

        return new ModelAndView("redirect:/home");
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
