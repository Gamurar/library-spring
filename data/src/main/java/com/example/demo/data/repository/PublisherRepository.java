package com.example.demo.data.repository;

import com.example.demo.data.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
