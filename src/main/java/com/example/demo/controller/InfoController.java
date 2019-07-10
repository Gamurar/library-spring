package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.service.BorrowedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final BorrowedBookService borrowedBookService;
    private final BookService bookService;


    @GetMapping(path = "/borrowed")
    public ModelAndView getBorrowedPage() {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("request", "borrowed");
        modelAndView.addObject("borrowedList", borrowedBookService.findAll());

        return modelAndView;
    }

    @GetMapping(path = "/books")
    public ModelAndView getBooksPage() {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("request", "books");
        modelAndView.addObject("bookList", bookService.findAll());

        return modelAndView;
    }

}
