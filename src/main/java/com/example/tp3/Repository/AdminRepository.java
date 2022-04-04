package com.example.tp3.Repository;

import com.example.tp3.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findAll();

}
