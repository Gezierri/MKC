package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
=======

public interface UserRepository extends JpaRepository<User, Long> {
>>>>>>> origin/main
}
