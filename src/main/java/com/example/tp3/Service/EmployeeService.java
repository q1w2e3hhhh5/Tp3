package com.example.tp3.Service;

import com.example.tp3.Model.*;
import com.example.tp3.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository adminRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ClientRepository clientRepository;


    public Employee createEmployee(String email, String passwords, String fullName) {
        return adminRepository.save(new Employee(email, passwords, fullName));
    }

    public Client createClient(String email, String password, String fullName/*, List<Document> borrows*/) {
        Client client = Client.builder().email(email).password(password).fullName(fullName)/*.borrows(borrows)*/.fee(0).build();
        return clientRepository.save(client);
    }

    public Book createBook(String title, int nbPages, String author, String category, String editor, int publicationYear, int quantity) {
        Book book = Book.builder().title(title).nbPages(nbPages).category(category).author(author).editor(editor).
                publicationYear(publicationYear).documentType("Book").quantity(quantity).borrowTimePeriod(3).build();
        return documentRepository.save(book);
    }

    public Cd createCd(String title, int publicationYear, String author, String editor, String category, int timeLength, int quantity) {
        Cd cd = Cd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).
                genre(category).timeLength(timeLength).documentType("Cd").quantity(quantity).borrowTimePeriod(2).build();
        return documentRepository.save(cd);
    }

    public Dvd createDvd(String title, int publicationYear, String author, String editor, String category, int timeLength, int quantity) {
        Dvd dvd = Dvd.builder().title(title).publicationYear(publicationYear).author(author).editor(editor).
        category(category).timeLength(timeLength).documentType("Dvd").quantity(quantity).borrowTimePeriod(1).build();
        return documentRepository.save(dvd);
    }

    public void chargeFee(Client client, int amount) {
        client.setFee(client.getFee()+amount);
        clientRepository.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
}
