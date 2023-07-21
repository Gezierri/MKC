package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Page<Client> listAll(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clientRepository.findAll(pageRequest);
    }

    public Client findClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(id, "Client id not found! "));
    }

    public Client updateClient(Client client, Long id) {
        Client obj = findClientById(id);
        BeanUtils.copyProperties(client, obj, "id");
        return clientRepository.save(obj);
    }

    public List<Client> findByNameContaining(String name) {
        return clientRepository.findByNameContaining(name);
    }

    public void delete(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }
}
