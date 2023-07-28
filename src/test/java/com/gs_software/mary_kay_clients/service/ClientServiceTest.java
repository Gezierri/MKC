package com.gs_software.mary_kay_clients.service;


import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.repository.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;

    Client client1;
    Client client2;

    @BeforeEach
    public void setup() {
        client1 = Client.builder()
                .id(1L)
                .name("joao")
                .phoneNumber("(11) 1 1111-1111")
                .dateBirth(LocalDate.now())
                .build();

        client2 = Client.builder()
                .id(2L)
                .name("maria")
                .phoneNumber("(22) 2 2222-2222")
                .dateBirth(LocalDate.now())
                .build();
    }

    @Test
    public void findClientById_Found(){
        Mockito.when(clientRepository.findById(1l)).thenReturn(Optional.of(client1));

        Client clientTest = clientService.findClientById(1L);

        Assertions.assertNotNull(clientTest);
    }

    @Test
    public void findClientById_NotFound(){
        Mockito.when(clientRepository.findById(100L)).thenReturn(Optional.empty());
        assertThrows(ObjectNotFoundException.class, () -> clientService.findClientById(100L));
    }

    @Test
    public void clientRepository_listAllClientByName_WithResult(){
        Mockito.when(clientRepository.findByNameContaining("m")).thenReturn(Collections.singletonList(client2));

        List<Client> result = clientService.findByNameContaining("m");

        assertNotNull(result);
    }
}
