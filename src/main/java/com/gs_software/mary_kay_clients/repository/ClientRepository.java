package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE LOWER(c.name) LIKE LOWER(CONCAT(:name, '%'))")
    List<Client> findByNameContaining(String name);
}