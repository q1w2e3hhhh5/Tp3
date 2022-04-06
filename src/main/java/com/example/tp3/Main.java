package com.example.tp3;

import com.example.tp3.Repository.*;
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


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Admin admin = adminService.createAdmin("admin@gmail.com", "admin", "Steve admin");
        final Admin admin1 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");
        final Admin admin2 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");

        System.out.println(admin);
        System.out.println(adminService.findAllAdmin());


        final Employee employee = employeeService.createEmployee("Employe1", "q1w2e3", "Bob the builder");

        final Book book0 = employeeService.createBook("Marvel", 189, "stan lee", "action", "Amazon", 1990, 10);
        final Book book1 = employeeService.createBook("Hello kitty", 12, "me", "Horror", "Amazon", 2000, 5);
        final Book book2 = employeeService.createBook("Hello bob the builder", 189, "you", "sci-fi", "Amazon", 2022, 10);

        final Cd cd = employeeService.createCd("Billie Jeans", 2002, "MJ", "MJ", "Country", 28,30);

        System.out.println(employee);
        System.out.println(book0);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(cd);

        System.out.println(employeeService.findDocuments());
        System.out.println(employeeService.findDocumentsByTitle("Hello")); //is it okay if im just putting one letter?
        System.out.println(employeeService.findDocumentsByAuthor("me"));
        System.out.println(employeeService.findDocumentsPublicationYear(1990));
        System.out.println(employeeService.findDocumentsByCategory("sci-fi"));


    }
}
