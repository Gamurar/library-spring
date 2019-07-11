package com.example.demo.data.service;


import com.example.demo.data.domain.Client;
import com.example.demo.data.domain.dto.ClientForm;

import java.util.List;

public interface ClientService {
    Client findById(Long id);

    ClientForm createClientForm(Client client);

    Client save(ClientForm clientForm);

    void deleteById(Long id);

    List<Client> findAll();


}
