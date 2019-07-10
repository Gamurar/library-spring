package com.example.demo.controller;

import com.example.demo.domain.BorrowedBook;
import com.example.demo.service.BorrowedBookService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BorrowController {

    private final ClientService clientService;
    private final BorrowedBookService borrowedBookService;


    @PostMapping(path = "/borrow-book")
    public ModelAndView borrowTheBook(@RequestParam String bookIsbn,
                                      @RequestParam Long clientId,
                                      @RequestParam int amount) {

        BorrowedBook borrowedBook = borrowedBookService.createBorrowedBook(bookIsbn, clientId, amount);
        borrowedBookService.save(borrowedBook);
        ModelAndView modelAndView = new ModelAndView("borrow");
        modelAndView.addObject("clientList", clientService.findAll());

        return modelAndView;
    }

}
