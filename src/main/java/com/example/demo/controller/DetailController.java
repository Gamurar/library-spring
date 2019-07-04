package com.example.demo.controller;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.utils.Constants.VIEW_BOOK_DETAIL;

@Controller
@RequestMapping("/detail")
public class DetailController {

    private BookService bookService;

    public DetailController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/book")
    public ModelAndView getBookDetailPage(@RequestParam String isbn) {
        ModelAndView modelAndView = new ModelAndView(VIEW_BOOK_DETAIL);
        modelAndView.addObject("book", bookService.findByIsbn(isbn));

        return modelAndView;
    }

}
