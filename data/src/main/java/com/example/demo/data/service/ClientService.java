package com.example.demo.data.service;


import com.example.demo.data.domain.Client;

import java.util.List;

public interface ClientService {
    Client findById(Long id);

    void deleteById(Long id);

    List<Client> findAll();

    Client save(Client client);


}
