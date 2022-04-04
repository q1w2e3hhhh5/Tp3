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




    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Admin admin = adminService.createAdmin("admin@gmail.com","admin","Steve admin");
        final Admin admin1 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");
        final Admin admin2 = adminService.createAdmin("admin@gmail.com","admin","Steve admin");

        System.out.println(admin);
        System.out.println(adminService.findAllAdmin());
    }
}
