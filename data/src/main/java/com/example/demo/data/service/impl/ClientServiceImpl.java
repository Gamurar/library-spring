package com.example.demo.data.service.impl;


import com.example.demo.data.domain.Client;
import com.example.demo.data.domain.dto.ClientForm;
import com.example.demo.data.repository.ClientRepository;
import com.example.demo.data.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ClientForm createClientForm(Client client) {
        ClientForm clientForm = new ClientForm();
        clientForm.setId(client.getId());
        clientForm.setFirstName(client.getFirstName());
        clientForm.setLastName(client.getLastName());
        clientForm.setAddress(client.getAddress());
        clientForm.setPhone(client.getPhone());

        return clientForm;
    }

    @Override
    public Client save(ClientForm clientForm) {
        return repository.save(createClient(clientForm));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    private Client createClient(ClientForm clientForm) {
        Client client = new Client();
        client.setId(clientForm.getId());
        client.setFirstName(clientForm.getFirstName());
        client.setLastName(clientForm.getLastName());
        client.setAddress(clientForm.getAddress());
        client.setPhone(clientForm.getPhone());

        return client;
    }
}
