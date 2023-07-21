package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}