package com.example.tp3.Service;

import com.example.tp3.Model.*;
import com.example.tp3.Repository.BorrowRepository;
import com.example.tp3.Repository.ClientRepository;
import com.example.tp3.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private BorrowRepository borrowRepository;

    public Client createClient(String email, String password, String fullName/*, List<Document> borrows*/) {
        Client client = Client.builder().email(email).password(password).fullName(fullName)/*.borrows(borrows)*/.fee(0).build();
        return clientRepository.save(client);
    }

    @Transactional
    public void payFee(Client client, int amount) {
        if (client.getFee() - amount < 0) {
            client.setFee(0);
            clientRepository.save(client);
            return;
        }
        client.setFee(client.getFee() - amount);
        clientRepository.save(client);
    }

    /*
      public void borrowDocument(Document document) {
        Borrow borrow = Borrow.builder(document, LocalDateTime.now(),LocalDateTime.now().plusWeeks(document.getBorrowTimePeriod()));
        return;borrowRepository.save(borrow);
    }
    */
}
