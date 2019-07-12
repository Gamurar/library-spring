package com.example.demo.web.controller;


import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.Client;
import com.example.demo.data.domain.Publisher;
import com.example.demo.data.domain.dto.AuthorDTO;
import com.example.demo.data.domain.dto.BookDTO;
import com.example.demo.data.domain.dto.ClientDTO;
import com.example.demo.data.domain.dto.PublisherDTO;
import com.example.demo.data.service.AuthorService;
import com.example.demo.data.service.ClientService;
import com.example.demo.data.service.PublisherService;
import com.example.demo.data.service.BookService;
import com.example.demo.web.service.dto.AuthorDTOService;
import com.example.demo.web.service.dto.BookDTOService;
import com.example.demo.web.service.dto.ClientDTOService;
import com.example.demo.web.service.dto.PublisherDTOService;
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
    private final BookDTOService bookDTOService;
    private final AuthorService authorService;
    private final AuthorDTOService authorDTOService;
    private final PublisherService publisherService;
    private final PublisherDTOService publisherDTOService;
    private final ClientService clientService;
    private final ClientDTOService clientDTOService;


    @GetMapping(path = "/book")
    public ModelAndView editBook(@RequestParam(value="isbn", required=false) String isbn) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        BookDTO bookDTO = bookDTOService.getBookForm(isbn);

        modelAndView.addObject("book", bookDTO);
        modelAndView.addObject("page", "book");
        return modelAndView;
    }


    @PostMapping(path = "/book")
    public ModelAndView addBook(@ModelAttribute("book") BookDTO bookDTO,
                                @RequestParam String action,
                                @RequestParam(value="book-cover", required=false) MultipartFile bookCover,
                                BindingResult result) {
        if (action.equals("save")) {
            bookDTOService.save(bookDTO, bookCover);
        }
        if (action.equals("delete")) {
            bookDTOService.delete(bookDTO);
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/author")
    public ModelAndView getAuthorEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("author", new AuthorDTO());
        } else {
            Author author = authorService.findById(id);
            AuthorDTO authorDTO = authorDTOService.createAuthorForm(author);
            modelAndView.addObject("author", authorDTO);
        }

        modelAndView.addObject("page", "author");

        return modelAndView;
    }

    @PostMapping(path = "/author")
    public ModelAndView editAuthor(@ModelAttribute("author") AuthorDTO authorDTO,
                                @RequestParam String action,
                                BindingResult result) {
        if (action.equals("save")) {
            authorDTOService.save(authorDTO);
        }
        if (action.equals("delete")) {
            authorService.deleteById(authorDTO.getId());
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/publisher")
    public ModelAndView getPublisherEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("publisher", new PublisherDTO());
        } else {
            Publisher publisher = publisherService.findById(id);
            PublisherDTO publisherDTO = publisherDTOService.createPublisherForm(publisher);
            modelAndView.addObject("publisher", publisherDTO);
        }

        modelAndView.addObject("page", "publisher");

        return modelAndView;
    }

    @PostMapping(path = "/publisher")
    public ModelAndView editPublisher(@ModelAttribute("publisher") PublisherDTO publisherDTO,
                                   @RequestParam String action,
                                   BindingResult result) {
        if (action.equals("save")) {
            publisherDTOService.save(publisherDTO);
        }
        if (action.equals("delete")) {
            publisherService.deleteById(publisherDTO.getId());
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping(path = "/client")
    public ModelAndView getClientEditPage(@RequestParam(value="id", required=false) Long id) {
        ModelAndView modelAndView = new ModelAndView(Constants.VIEW_EDIT);
        if (id == null) {
            modelAndView.addObject("client", new ClientDTO());
        } else {
            Client client = clientService.findById(id);
            ClientDTO clientDTO = clientDTOService.createClientForm(client);
            modelAndView.addObject("client", clientDTO);
        }

        modelAndView.addObject("page", "client");

        return modelAndView;
    }

    @PostMapping(path = "/client")
    public ModelAndView editClient(@ModelAttribute("client") ClientDTO clientDTO,
                                   @RequestParam String action,
                                   BindingResult result) {
        if (action.equals("save")) {
            clientDTOService.save(clientDTO);
        }
        if (action.equals("delete")) {
            clientService.deleteById(clientDTO.getId());
        }

        return new ModelAndView("redirect:/home");
    }
}
