package com.example.demo.domain.dto;

import com.example.demo.domain.Author;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookForm {
    private String isbn;
    private String name;
    private String publisher;
    private List<AuthorForm> authors = new ArrayList<>(10);
    private String publishYear;
    private Integer copies;
    private String pictureName;
    private String pictureContent;
}
