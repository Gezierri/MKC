package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.User;
import com.gs_software.mary_kay_clients.entity.dto.UserDto;
import com.gs_software.mary_kay_clients.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> signup(@RequestBody @Valid UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("User successfully created");
    }


    /*public ResponseEntity<User> insert(@RequestBody @Valid User user) {
        User obj = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }*/
}
