package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
