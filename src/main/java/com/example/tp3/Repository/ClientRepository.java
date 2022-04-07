package com.example.tp3.Repository;

import com.example.tp3.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
