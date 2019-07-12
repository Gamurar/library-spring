package com.example.demo.web.service.dto;

import com.example.demo.data.domain.Author;
import com.example.demo.data.domain.dto.AuthorDTO;
import com.example.demo.data.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorDTOService {

    private final AuthorService authorService;

    private Author createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        if (authorDTO.getId() != -1L) {
            author.setId(authorDTO.getId());
        }
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());

        return author;
    }

    public AuthorDTO createAuthorForm(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());

        return authorDTO;
    }

    public Author save(AuthorDTO authorDTO) {
        Author author = createAuthor(authorDTO);

        return authorService.save(author);
    }
}
