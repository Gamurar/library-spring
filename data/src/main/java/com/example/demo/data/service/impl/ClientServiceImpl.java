package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Client;
import com.example.demo.data.repository.ClientRepository;
import com.example.demo.data.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public Client findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }


}
