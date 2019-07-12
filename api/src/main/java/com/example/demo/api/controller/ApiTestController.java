package com.example.demo.api.controller;


import com.example.demo.data.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class ApiTestController {

    private final BookRepository bookRepository;

    @GetMapping
    public Map getAllBooks() {
        log.info("Request to get list");
        return Collections.singletonMap("test", "123");
    }
}
