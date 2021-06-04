package com.example.demo.api.rest;


import com.example.demo.data.domain.Client;
import com.example.demo.data.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "Client API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Client Service"})
public class ClientRestController {

    private final ClientService clientService;


    @PostMapping(value = "/clients")
    @ApiOperation(value = "Add a client")
    public Client createClient(@Valid @RequestBody Client client) {
        log.debug("REST request to save Client : {}", client);
        client.setId(null);
        return clientService.save(client);
    }

    @PutMapping(value = "/clients")
    @ApiOperation(value = "Edit a specific client")
    public Client updateClient(@Valid @RequestBody Client client) {
        log.debug("REST request to update Client : {}", client);
        if (client.getId() == null) {
            log.error("Invalid ID");
            return null;
        }

        return clientService.save(client);
    }

    @GetMapping("/clients")
    @ApiOperation(value = "Get all clients")
    public List<Client> getAllClients() {
        log.debug("REST request to get all clients");

        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    @ApiOperation(value = "Get a specific client by id")
    public Client getClient(@PathVariable Long id) {
        log.debug("REST request to get client with id " + id);

        return clientService.findById(id);
    }

    @DeleteMapping("/clients/{id}")
    @ApiOperation(value = "Delete a client by id")
    public String deleteClient(@PathVariable Long id) {
        log.debug("REST request to delete client with id " + id);
        clientService.deleteById(id);

        return "The client with id " + id + " deleted!";
    }

}
