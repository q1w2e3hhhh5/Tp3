package com.example.tp3;

import com.example.tp3.Model.*;
import com.example.tp3.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private DocumentService documentService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Admin admin = adminService.createAdmin("admin@gmail.com", "admin", "Steve admin");

        final Employee employee = employeeService.createEmployee("Employe1", "q1w2e3", "Bob the builder");

        final Client clientMadeByClientService = clientService.createClient("salah@gmail.com", "1234", "Salah");
        final Client clientMadeByEmployeeService = employeeService.createClient("edine@gmail.com", "4321", "edine");

        final Book book0 = employeeService.createBook("Marvel", 189, "stan lee", "action", "Amazon", 1990, 10);
        final Book book1 = employeeService.createBook("Hello kitty", 12, "me", "Horror", "Amazon", 2000, 5);
        final Book book2 = employeeService.createBook("Hello bob the builder", 189, "you", "sci-fi", "Amazon", 2022, 10);

        final Cd cd = employeeService.createCd("Billie Jeans", 1990, "MJ", "MJ", "Country", 28, 30);

        final Dvd dvd = employeeService.createDvd("Kung fu panda", 1990, "me", "disney?", "family", 68, 50);


        /*todo must complete the borrow part
        clientService.borrowDocument(dvd);
        final Borrow borrow = clientService.borrowDocument(dvd);
        */

        System.out.println(documentService.findDocumentsByTitle("Marvel"));
        System.out.println(employeeService.findClientByEmail("salah@gmail.com"));

        //clientService.borrowDocument(clientMadeByClientService,dvd);
        //clientService.borrowDocument(3,5);
        //clientService.findListOfBorrowsByClient(3);


        /*        System.out.println(adminService.findAllAdmin());

        System.out.println("******* Client Service search *******");
        System.out.println(documentService.findDocuments());
        System.out.println(documentService.findDocumentsByTitle("bob"));
        System.out.println(documentService.findDocumentsByAuthor("MJ"));
        System.out.println(documentService.findDocumentsPublicationYear(2022));
        System.out.println(documentService.findDocumentsByCategory("family"));
        System.out.println(documentService.findDocumentsByEditor("Amazon"));
        System.out.println(documentService.findAllBooks());
        System.out.println(documentService.findAllCds());
        System.out.println(documentService.findAllDvds());

        System.out.println("******* Fee Service *******");
        employeeService.chargeFee(clientMadeByClientService, 10);
        employeeService.chargeFee(clientMadeByEmployeeService, 50);
        System.out.println("******* Before *******");
        System.out.println(employeeService.findAllClients());

        clientService.payFee(clientMadeByClientService, 30);
        clientService.payFee(clientMadeByEmployeeService, 30);
        System.out.println("******* After *******");
        System.out.println(employeeService.findAllClients());*/


    }
}
