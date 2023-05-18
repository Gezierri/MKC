package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.entity.dto.ClientDto;
import com.gs_software.mary_kay_clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("clients")
@RestController
@RequiredArgsConstructor
public class ClientResource {

    final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<Client>> listAll(Pageable pageable){
        Page<Client> clients = clientService.listAll(pageable);
        return ResponseEntity.ok(clients);
    }
}
