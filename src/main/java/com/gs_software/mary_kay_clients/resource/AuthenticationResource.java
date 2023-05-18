package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.dto.UserDto;
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

    @PostMapping
    public ResponseEntity<UserDto> login(@RequestBody @Valid UserDto userDto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(userDto.email(), userDto.password());
        System.out.println(authenticationToken);
        var authentication = manager.authenticate(authenticationToken);
        return ResponseEntity.ok().build();
    }
}
