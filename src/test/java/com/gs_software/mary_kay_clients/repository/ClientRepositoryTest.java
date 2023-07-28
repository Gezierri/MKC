package com.gs_software.mary_kay_clients.repository;

import com.gs_software.mary_kay_clients.entity.Address;
import com.gs_software.mary_kay_clients.entity.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void clientRepository_Save(){
        Address address = Address.builder()
                .city("city test")
                .state("state test")
                .complement("")
                .country("country test")
                .street("street test")
                .number("123")
                .postalCode("123456")
                .neighborhood("neighborhood test")
                .build();

        Client client = Client.builder()
                .name("teste")
                .phoneNumber("(11) 1 1111-1111")
                .dateBirth(LocalDate.now())
                .address(address)
                .build();

        Client clientSaved = clientRepository.save(client);

        Assertions.assertThat(clientSaved).isNotNull();
        Assertions.assertThat(clientSaved.getId()).isGreaterThan(0);
    }

    @Test
    public void clientRepository_listAllClientByName_WithoutResult(){
        List<Client> result = clientRepository.findByNameContaining("z");
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void clientRepository_listAllClientByName_WithResult(){
        List<Client> result = clientRepository.findByNameContaining("n");
        System.out.printf("RESULT -> " + result);
        Assertions.assertThat(result.size()).isGreaterThan(0);
    }
}
