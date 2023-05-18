package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
