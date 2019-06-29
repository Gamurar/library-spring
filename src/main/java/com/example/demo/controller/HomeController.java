package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {


    private static final String VIEW_HOME = "home";


    public HomeController() {
        super();
    }


    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public final String showWelcome() {
        return VIEW_HOME;
    }

    @PostMapping(path = "/add-book", produces = "text/html")
    public String addBook() {
        return "add-book";
    }

}
