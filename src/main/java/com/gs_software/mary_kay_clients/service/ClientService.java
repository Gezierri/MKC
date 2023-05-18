package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Page<Client> listAll(Pageable pageable){
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients;
    }
}
