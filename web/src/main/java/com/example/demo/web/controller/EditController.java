package com.example.demo.web.controller;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.Client;
import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.AuthorForm;
import com.example.demo.data.domain.dto.BookForm;
import com.example.demo.data.domain.dto.ClientForm;
import com.example.demo.data.domain.dto.PublisherForm;
import com.example.demo.data.service.AuthorService;
import com.example.demo.data.service.ClientService;
import com.example.demo.data.service.PublisherService;
import com.example.demo.web.service.BookService;
import com.example.demo.web.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/edit")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
@RequiredArgsConstructor
public class EditController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final ClientService clientService;


    @GetMapping(path = "/book")
    public ModelAndView editBook(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        BookForm bookForm = bookService.getBookForm(isbn);

        modelAndView.addObject("book", bookForm);
        modelAndView.addObject("page", "book");
        return modelAndView;
    }


    @PostMapping(path = "/book")
    public ModelAndView addBook(@ModelAttribute("book") BookForm bookForm,
                                @RequestParam String action,
                                @RequestParam(value="book-cover", required=false) MultipartFile bookCover,
                                BindingResult result) {
        if (action.equals("save")) {
            bookService.save(bookForm, bookCover);
        }
        if (action.equals("delete")) {
            bookService.delete(bookForm);
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/author")
    public ModelAndView getAuthorEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("author", new AuthorForm());
        } else {
            Author author = authorService.findById(id);
            AuthorForm authorForm = authorService.createAuthorForm(author);
            modelAndView.addObject("author", authorForm);
        }

        modelAndView.addObject("page", "author");

        return modelAndView;
    }

    @PostMapping(path = "/author")
    public ModelAndView editAuthor(@ModelAttribute("author") AuthorForm authorForm,
                                @RequestParam String action,
                                BindingResult result) {
        if (action.equals("save")) {
            authorService.save(authorForm);
        }
        if (action.equals("delete")) {
            authorService.deleteById(authorForm.getId());
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/publisher")
    public ModelAndView getPublisherEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("publisher", new PublisherForm());
        } else {
            Publisher publisher = publisherService.findById(id);
            PublisherForm publisherForm = publisherService.createPublisherForm(publisher);
            modelAndView.addObject("publisher", publisherForm);
        }

        modelAndView.addObject("page", "publisher");

        return modelAndView;
    }

    @PostMapping(path = "/publisher")
    public ModelAndView editPublisher(@ModelAttribute("publisher") PublisherForm publisherForm,
                                   @RequestParam String action,
                                   BindingResult result) {
        if (action.equals("save")) {
            publisherService.save(publisherForm);
        }
        if (action.equals("delete")) {
            publisherService.deleteById(publisherForm.getId());
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/client")
    public ModelAndView getClientEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("client", new ClientForm());
        } else {
            Client client = clientService.findById(id);
            ClientForm clientForm = clientService.createClientForm(client);
            modelAndView.addObject("client", clientForm);
        }

        modelAndView.addObject("page", "client");

        return modelAndView;
    }

    @PostMapping(path = "/client")
    public ModelAndView editClient(@ModelAttribute("client") ClientForm clientForm,
                                   @RequestParam String action,
                                   BindingResult result) {
        if (action.equals("save")) {
            clientService.save(clientForm);
        }
        if (action.equals("delete")) {
            clientService.deleteById(clientForm.getId());
        }

        return new ModelAndView("redirect:/home");
    }
}
