package com.example.tp3.service;

import com.example.tp3.model.*;
import com.example.tp3.repository.BorrowRepository;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.repository.DocumentRepository;
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

    public Client createClient(String email, String password, String fullName/*, List<Document> borrows*/) {
        Client client = Client.builder().email(email).password(password).fullName(fullName)/*.borrows(borrows)*/.fee(0).build();
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

    public void borrowDocument(Long clientId, Long documentId) {
        this.findClientById(clientId);


        Borrow borrow = new Borrow(this.findDocumentById(documentId));

        //clientRepository.findBy

    }

    public void findListOfBorrowsByClient(int clientId) {
        //   return clientRepository.find
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    private Optional<Document> findDocumentById(Long id) {
        return documentRepository.findById(id);
    }

/*    public DocumentDto findDocumentById(Long id){
        Document document = documentRepository.findById(id);
        DocumentDto documentDto = DtoUtils.getDocumentDto(document);
        return documentDto;

    }*/



    /*
      public void borrowDocument(Document document) {
        Borrow borrow = Borrow.builder(document, LocalDateTime.now(),LocalDateTime.now().plusWeeks(document.getBorrowTimePeriod()));
        return;borrowRepository.save(borrow);
    }
    */
}
