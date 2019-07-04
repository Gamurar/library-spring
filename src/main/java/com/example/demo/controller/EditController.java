package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.domain.dto.AuthorForm;
import com.example.demo.service.AuthorService;
import com.example.demo.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/edit")
public class EditController {

    private AuthorService authorService;

    public EditController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/author")
    public ModelAndView editBook(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        boolean isNew = false;
        if (id == null) {
            modelAndView.addObject("author", new AuthorForm());
            isNew = true;
        } else {
            Author author = authorService.findById(id);
            AuthorForm authorForm = authorService.createAuthorForm(author);
            modelAndView.addObject("author", authorForm);
        }

        modelAndView.addObject("page", "author");
        modelAndView.addObject("isNew", isNew);

        return modelAndView;
    }
}
