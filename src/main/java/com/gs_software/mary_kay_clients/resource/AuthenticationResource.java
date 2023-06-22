package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.User;
import com.gs_software.mary_kay_clients.entity.dto.TokenJwt;
import com.gs_software.mary_kay_clients.entity.dto.UserDto;
import com.gs_software.mary_kay_clients.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<TokenJwt> login(@RequestBody @Valid UserDto userDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(userDto.email(), userDto.password());
        var authentication = manager.authenticate(authenticationToken);
        String tokenJwt = jwtService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwt(tokenJwt));
    }
}
