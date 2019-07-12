package com.example.demo.web.controller;


import com.example.demo.data.domain.dto.BookDTO;
import com.example.demo.data.service.ClientService;
import com.example.demo.data.service.BookService;
import com.example.demo.web.service.dto.BookDTOService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.web.utils.Constants.VIEW_BOOK_DETAIL;


@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {

    private final BookService bookService;
    private final BookDTOService bookDTOService;
    private final ClientService clientService;


    @GetMapping(path = "/book")
    public ModelAndView getBookDetailPage(@RequestParam String isbn) {
        ModelAndView modelAndView = new ModelAndView(VIEW_BOOK_DETAIL);
        BookDTO bookDTO = bookDTOService.createBookForm(bookService.findByIsbn(isbn));
        modelAndView.addObject("book", bookDTO);

        modelAndView.addObject("clientList", clientService.findAll());

        return modelAndView;
    }

}
