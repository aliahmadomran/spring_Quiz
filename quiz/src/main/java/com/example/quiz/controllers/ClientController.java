package com.example.quiz.controllers;

import com.example.quiz.models.Client;
import com.example.quiz.models.Product;
import com.example.quiz.services.ClientService;
import com.example.quiz.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "salesSystem/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }


    @PutMapping("/updateClient/{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId,@RequestBody Client client){
        clientService.updateClient(clientId,client);
    }

}
