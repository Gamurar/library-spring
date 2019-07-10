package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.domain.dto.ClientForm;

import java.util.List;

public interface ClientService {
    Client findById(Long id);

    ClientForm createClientForm(Client client);

    Client save(ClientForm clientForm);

    void deleteById(Long id);

    List<Client> findAll();


}
