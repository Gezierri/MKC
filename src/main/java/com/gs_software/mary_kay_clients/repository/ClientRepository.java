package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
