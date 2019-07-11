package com.example.demo.data.domain.dto;

import lombok.Data;

@Data
public class ClientForm {
    private Long id = -1L;

    private String firstName;

    private String lastName;

    private String address;

    private String phone;
}
