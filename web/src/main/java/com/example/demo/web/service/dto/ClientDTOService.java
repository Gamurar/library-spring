package com.example.demo.web.service.dto;

import com.example.demo.data.domain.Client;
import com.example.demo.data.domain.dto.ClientDTO;
import com.example.demo.data.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientDTOService {

    private final ClientService clientService;

    public ClientDTO createClientForm(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setPhone(client.getPhone());

        return clientDTO;
    }

    private Client createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setAddress(clientDTO.getAddress());
        client.setPhone(clientDTO.getPhone());

        return client;
    }

    public Client save(ClientDTO clientDTO) {
        return clientService.save(createClient(clientDTO));
    }
}
