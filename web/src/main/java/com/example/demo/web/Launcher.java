package com.example.demo.web;


import com.example.demo.web.config.LibraryProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Launcher implements CommandLineRunner {

    private final LibraryProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        Path storagePath = Paths.get(properties.getStoragePath());
        if (Files.notExists(storagePath)) {
            log.debug("Create storage path : '{}'", properties.getStoragePath());
            try {
                Files.createDirectory(storagePath);
            } catch (IOException e) {
                log.error("Create storage path exception message: {}", e.getMessage());
            }
        }
    }
}
