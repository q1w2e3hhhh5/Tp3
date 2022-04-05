package com.example.tp3.Service;

import com.example.tp3.Model.Employee;
import com.example.tp3.Repository.AdminRepository;
import com.example.tp3.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository adminRepository;



    public Employee createEmployee(String email, String passwords, String fullName) {
        return adminRepository.save(new Employee(email,passwords,fullName));
    }

}
