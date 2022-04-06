package com.example.tp3.Service;

import com.example.tp3.Model.*;
import com.example.tp3.Repository.BorrowRepository;
import com.example.tp3.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


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
    public void payFee(Client client,int amount) {
        if(client.getFee()-amount < 0){
            client.setFee(0);
            /*            //do I give him back his change?
            System.out.print("give back: ");
            System.out.println(amount-client.getFee()+"$");*/
            clientRepository.save(client);
            return;
        }
        client.setFee(client.getFee()-amount);
        clientRepository.save(client);
    }

    /*
    *     @Transactional //aborts the method if the there's an exception
    public void transfertDeCompteACompte(Compte source, Compte destination, int montant){
        source.setBalance(source.getBalance()-montant);
        destination.setBalance(destination.getBalance()+montant);
        compteRepository.save(source);
        compteRepository.save(destination);
    }*/

/*    public void borrowDocument(Document document) {
        Borrow borrow = Borrow.builder(document, LocalDateTime.now(),LocalDateTime.now().plusWeeks(document.getBorrowTimePeriod()));
        return;borrowRepository.save(borrow);
    }*/
    //todo client must be able to search documents and whatnot




}
