package com.gs_software.mary_kay_clients.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gs_software.mary_kay_clients.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String generateToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.create()
                    .withIssuer("API MKC")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirationToken())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Error to created token" + ex.getMessage());
        }
    }

    public Instant expirationToken() {
        return LocalDateTime.now().plusMinutes(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
