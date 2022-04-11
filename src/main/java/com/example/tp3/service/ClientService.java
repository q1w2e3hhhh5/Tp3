package com.example.tp3.service;

import com.example.tp3.model.*;
import com.example.tp3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BorrowService borrowService;

    public Client createClient(String email, String password, String fullName) {
        Client client = Client.builder().email(email).password(password).fullName(fullName).fee(0).build();
        return clientRepository.save(client);
    }

    @Transactional
    public void payFee(Client client, int amount) {
        if (client.getFee() - amount < 0) {
            client.setFee(0);
            clientRepository.save(client); //just give him his money back
            return;
        }
        client.setFee(client.getFee() - amount);
        clientRepository.save(client);
    }

    @Transactional
    public void borrowDocument(Long clientId, Long documentId) {
        this.findClientById(clientId);
        var clientOpt = this.findClientById(clientId);
        var documentOpt = this.findDocumentById(documentId);

        if(clientOpt.isEmpty() || documentOpt.isEmpty()){return;}
        var client = clientOpt.get();
        var document = documentOpt.get();

        Borrow borrow = borrowService.createBorrow(document,client);

        client.addBorrow(borrow);
        document.setQuantity(document.getQuantity()-1);

        documentRepository.save(document);
        clientRepository.save(client);
    }

    private Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    private Optional<Document> findDocumentById(Long id) {
        return documentRepository.findById(id);
    }

}
