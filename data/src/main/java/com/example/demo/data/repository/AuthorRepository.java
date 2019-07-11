package com.example.demo.data.repository;


import com.example.demo.data.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
