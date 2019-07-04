package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.domain.dto.AuthorForm;
import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    private static final String VIEW_HOME = "all-books";
    private static final String VIEW_EDIT = "edit";
    private static final String VIEW_CATALOG = "catalog";

    private BookService bookService;


    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(path = "/all-books")
    public ModelAndView getAllBooksPage(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView model = new ModelAndView(VIEW_HOME);

        if (isbn != null) {
            Book book = bookService.findByIsbn(isbn);
            BookForm bookForm = bookService.createBookForm(book);
            model.addObject("book", bookForm);

            return model;
        }

        List<Book> bookList = bookService.findAll();
        model.addObject("bookList", bookList);
        model.addObject("book", new BookForm());

        return model;
    }

    @GetMapping(path = {"/home", "/"})
    public ModelAndView getCatalogPage() {
        ModelAndView modelAndView = new ModelAndView(VIEW_CATALOG);
        modelAndView.addObject("books", bookService.findAll());

        return modelAndView;
    }

    @GetMapping(path = "/edit")
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




}
