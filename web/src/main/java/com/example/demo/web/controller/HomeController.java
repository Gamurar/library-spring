package com.example.demo.web.controller;


import com.example.demo.data.domain.Book;
import com.example.demo.data.domain.dto.BookDTO;
import com.example.demo.data.service.BookService;
import com.example.demo.web.service.dto.BookDTOService;
import com.example.demo.web.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;
    private final BookDTOService bookDTOService;


    @GetMapping(path = "/all-books")
    public ModelAndView getAllBooksPage(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView model = new ModelAndView(Constants.VIEW_HOME);

        if (isbn != null) {
            Book book = bookService.findByIsbn(isbn);
            BookDTO bookDTO = bookDTOService.createBookForm(book);
            model.addObject("book", bookDTO);

            return model;
        }

        List<Book> bookList = bookService.findAll();
        model.addObject("bookList", bookList);
        model.addObject("book", new BookDTO());

        return model;
    }

    @GetMapping(path = {"/home", "/"})
    public ModelAndView getCatalogPage() {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_CATALOG);
        List<BookDTO> bookDTOS = createBookForms(bookService.findAll());
        modelAndView.addObject("books", bookDTOS);

        return modelAndView;
    }

    private List<BookDTO> createBookForms(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        books.forEach(book -> bookDTOS.add(bookDTOService.createBookForm(book)));
        return bookDTOS;
    }


}
