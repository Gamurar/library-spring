package com.example.demo.domain.dto;

import lombok.*;

@Data
public class BookForm {
    private String isbn;
    private String name;
    private String publisher;
    private String author;
    private String publishYear;
    private Integer copies;
}
