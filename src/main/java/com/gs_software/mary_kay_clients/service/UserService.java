package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.User;
import com.gs_software.mary_kay_clients.entity.dto.UserDto;
import com.gs_software.mary_kay_clients.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gs_software.mary_kay_clients.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.email());
        user.setPassword(encoder.encode(userDto.password()));
        userRepository.save(user);
    }
}
