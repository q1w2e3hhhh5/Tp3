package com.example.tp3.Service;

import com.example.tp3.Model.Admin;
import com.example.tp3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public Admin createAdmin(String email, String password, String fullname) {
        return adminRepository.save(new Admin(email,password,fullname));
    }


    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }
}
