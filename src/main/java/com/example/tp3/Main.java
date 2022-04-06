package com.example.tp3;

import com.example.tp3.Repository.*;
import com.example.tp3.Model.*;
import com.example.tp3.Service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Main implements CommandLineRunner{

    @Autowired
    private AdminService adminService;

    @Autowired
    private EmployeeService employeeService;




    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Admin admin = adminService.createAdmin("admin@gmail.com","admin","Steve admin");
/*        final Admin admin1 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");
        final Admin admin2 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");*/

        System.out.println(admin);
        System.out.println(adminService.findAllAdmin());


        final Employee employee = employeeService.createEmployee("Employe1","q1w2e3","Bob the builder");

        final Book book = employeeService.createBook("Marvel", 189, "comic", "Stan lee",  "action", "Marvel",2001,10);

        System.out.println(employee);
        System.out.println(book);


    }
}
