package com.example.quiz.services;

import com.example.quiz.models.Client;
import com.example.quiz.models.Product;
import com.example.quiz.repository.ClientRepo;
import com.example.quiz.repository.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    Logger logger = LoggerFactory.getLogger(ClientService.class);
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public void addNewClient(Client client) {

        clientRepo.save(client);
        logger.info(" new client added successfully");
    }

    public List<Client> getAllClients(){
        logger.info("get all clients");
        return  clientRepo.findAll();
    }



    @Transactional
    public void updateClient(Long clientId,Client updatedclient ) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(()->new IllegalStateException(
                        "Product with id :"+clientId+" does not exist"));

        if(updatedclient.getClientName() != null &&
                updatedclient.getClientName().length() > 0 &&
                !Objects.equals(client.getClientName(),updatedclient.getClientName())){

            client.setClientName(updatedclient.getClientName());
        }
        if(updatedclient.getClientLastName() != null &&
                updatedclient.getClientLastName().length() > 0 &&
                !Objects.equals(client.getClientLastName(),updatedclient.getClientLastName())){

            client.setClientLastName(updatedclient.getClientLastName());
        }
        if(updatedclient.getClientMobile() != null &&
                updatedclient.getClientMobile() > 0 &&
                !Objects.equals(client.getClientMobile(),updatedclient.getClientMobile())){

            client.setClientMobile(updatedclient.getClientMobile());
        }

        logger.info("Client with id "+clientId+" updated successfully");


    }

}
