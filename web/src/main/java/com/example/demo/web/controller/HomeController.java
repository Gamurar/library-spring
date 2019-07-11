package com.example.demo.web.controller;


import com.example.demo.data.domain.Book;
import com.example.demo.data.domain.dto.BookForm;
import com.example.demo.web.service.BookService;
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


    @GetMapping(path = "/all-books")
    public ModelAndView getAllBooksPage(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView model = new ModelAndView(Constants.VIEW_HOME);

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
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_CATALOG);
        List<BookForm> bookForms = createBookForms(bookService.findAll());
        modelAndView.addObject("books", bookForms);

        return modelAndView;
    }

    private List<BookForm> createBookForms(List<Book> books) {
        List<BookForm> bookForms = new ArrayList<>();
        books.forEach(book -> bookForms.add(bookService.createBookForm(book)));
        return bookForms;
    }


}
