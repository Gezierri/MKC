package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT(:name, '%'))")
    List<Product> findByNameContaining(String name);
}