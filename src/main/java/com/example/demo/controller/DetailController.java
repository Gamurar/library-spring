package com.example.demo.controller;

import com.example.demo.domain.dto.BookForm;
import com.example.demo.service.BookService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.utils.Constants.VIEW_BOOK_DETAIL;

@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {

    private final BookService bookService;
    private final ClientService clientService;


    @GetMapping(path = "/book")
    public ModelAndView getBookDetailPage(@RequestParam String isbn) {
        ModelAndView modelAndView = new ModelAndView(VIEW_BOOK_DETAIL);
        BookForm bookForm = bookService.createBookForm(bookService.findByIsbn(isbn));
        modelAndView.addObject("book", bookForm);

        modelAndView.addObject("clientList", clientService.findAll());

        return modelAndView;
    }

}
