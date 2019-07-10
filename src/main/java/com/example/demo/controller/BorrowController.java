package com.example.demo.controller;

import com.example.demo.domain.BorrowedBook;
import com.example.demo.service.BorrowedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowedBookService borrowedBookService;


    @PostMapping(path = "/borrow-book")
    public ModelAndView borrowTheBook(@RequestParam String bookIsbn,
                                      @RequestParam Long clientId) {

        BorrowedBook borrowedBook = borrowedBookService.createBorrowedBook(bookIsbn, clientId);
        BorrowedBook savedBorrowedBook = borrowedBookService.save(borrowedBook);
        ModelAndView modelAndView = new ModelAndView("borrow-result");
        modelAndView.addObject("borrowedBook", savedBorrowedBook);

        return modelAndView;
    }

    @PostMapping(path = "/return-borrowed-books")
    public ModelAndView returnBorrowedBooks(@RequestParam String checkedBorrowedBooksId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/info/borrowed");
        if(checkedBorrowedBooksId.isEmpty()) {
            return modelAndView;
        }

        String[] borrowedBooksId = checkedBorrowedBooksId.split(",");
        long[] ids = Arrays.stream(borrowedBooksId)
                .mapToLong(Long::valueOf).toArray();

        borrowedBookService.delete(ids);

        return modelAndView;
    }

}
