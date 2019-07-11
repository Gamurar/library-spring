package com.example.demo.data.domain.dto;

import lombok.Data;

@Data
public class AuthorForm {
    private Long id = -1L;
    private String firstName;
    private String lastName;
}
