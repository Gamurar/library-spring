//package com.example.demo.api.controller;
//
//import com.example.demo.data.domain.Client;
//import com.example.demo.data.service.ClientService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ClientController {
//
//    private final ClientService clientService;
//
//    @GetMapping("/clients")
//    public List<Client> getClient() {
//        return clientService.findAll();
//    }
//
//    @GetMapping("/client")
//    public Client getClient(@RequestParam Long id) {
//        return clientService.findById(id);
//    }
//}

