package com.example.demo.controller;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView showHome() {
        ModelAndView model = new ModelAndView(VIEW_HOME);
        List<Book> bookList = bookService.findAll();
        model.addObject("bookList", bookList);
        model.addObject("newBook", new BookForm());

        return model;
    }

    @PostMapping(path = "/addBook")
    public ModelAndView addBook(@ModelAttribute("newBook") BookForm bookForm,
                                BindingResult result) {
        System.out.println("Request for saving the book is here...");
        bookService.save(bookForm);

        return showHome();
    }


}
