package com.example.demo.data.repository;


import com.example.demo.data.domain.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
