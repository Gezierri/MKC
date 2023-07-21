package com.gs_software.mary_kay_clients;

import com.gs_software.mary_kay_clients.entity.User;
import com.gs_software.mary_kay_clients.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MaryKayClientsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MaryKayClientsApplication.class, args);
	}

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(null, "teste@email.com", encoder.encode("123"));
		userRepository.save(user);
	}
}
