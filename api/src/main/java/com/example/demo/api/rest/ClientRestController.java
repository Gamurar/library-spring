package com.example.demo.api.rest;


import com.example.demo.data.domain.Client;
import com.example.demo.data.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientRestController {

    private final ClientService clientService;


    @PostMapping(value = "/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        log.debug("REST request to save Client : {}", client);
        if (client.getId() != null) {
            log.error("A new client cannot already have an ID");
            return null;
        }

        return clientService.save(client);
    }

    @PutMapping(value = "/clients")
    public Client updateClient(@Valid @RequestBody Client client) {
        log.debug("REST request to update Client : {}", client);
        if (client.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return clientService.save(client);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        log.debug("REST request to get all clients");

        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        log.debug("REST request to get client with id " + id);

        return clientService.findById(id);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        log.debug("REST request to delete client with id " + id);
        clientService.deleteById(id);

        return "The client with id " + id + " deleted!";
    }

}
