package com.example.demo.data;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppData {

    public static void main(String[] args) {
        SpringApplication.run(AppData.class, args);
    }
}
