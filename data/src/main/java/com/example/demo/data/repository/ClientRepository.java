package com.example.demo.data.repository;


import com.example.demo.data.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
