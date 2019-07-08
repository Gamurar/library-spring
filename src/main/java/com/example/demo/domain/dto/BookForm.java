package com.example.demo.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.utils.Constants.DEFAULT_PICTURE_CONTENT;

@Data
public class BookForm {
    private String isbn;
    private String name;
    private PublisherForm publisher;
    private List<AuthorForm> authors = new ArrayList<>(10);
    private String publishYear;
    private Integer copies = 0;
    private String pictureName;
    private String pictureContent = DEFAULT_PICTURE_CONTENT;
}
