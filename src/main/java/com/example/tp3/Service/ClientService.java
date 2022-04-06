package com.example.tp3.Service;

import com.example.tp3.Model.*;
import com.example.tp3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(String email, String password, String fullName) {
        return clientRepository.save(new Client(email,password,fullName));
    }

    //todo client must be able to search documents and whatnot




}
