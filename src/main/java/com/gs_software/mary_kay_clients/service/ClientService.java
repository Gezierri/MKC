package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Page<Client> listAll(Integer page, Integer linesPerPage) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage);
        return clientRepository.findAll(pageRequest);
    }

    public Client findByName(String name) {
        Optional<Client> client = clientRepository.findByName(name);
        return client.orElseThrow(() -> new NoSuchElementException("Not object with name " + name));
    }

    public Client findClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(id, "Client id not found! "));
    }

    public Client updateClient(Client client, Long id) {
        Client obj = findClientById(id);
        BeanUtils.copyProperties(obj, client);
        return clientRepository.save(obj);
    }
}
