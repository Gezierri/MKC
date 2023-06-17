package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.entity.dto.ClientDto;
import com.gs_software.mary_kay_clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Pageable;
>>>>>>> origin/main
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("clients")
@RestController
@RequiredArgsConstructor
public class ClientResource {

<<<<<<< HEAD
    private final ClientService clientService;
=======
    final ClientService clientService;
>>>>>>> origin/main

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto);
<<<<<<< HEAD
        clientService.save(client);
=======

>>>>>>> origin/main
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

<<<<<<< HEAD
    @GetMapping("/page")
    public ResponseEntity<Page<ClientDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage
    ) {
        Page<Client> clients = clientService.listAll(page, linesPerPage);
        Page<ClientDto> clientDtoPage = clients.map(ClientDto::new);
        return ResponseEntity.ok().body(clientDtoPage);
    }

    @GetMapping
    public ResponseEntity<ClientDto> findByName(@RequestParam String name) {
        Client client = clientService.findByName(name);
        ClientDto clientDto = new ClientDto(client);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id) {
        Client client = clientService.findClientById(id);
        ClientDto clientDto = new ClientDto(client);
        return ResponseEntity.ok(clientDto);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto, @PathVariable Long id){
        Client client = new Client(clientDto);
        return ResponseEntity.ok(client);
    }*/
=======
    @GetMapping
    public ResponseEntity<Page<Client>> listAll(Pageable pageable){
        Page<Client> clients = clientService.listAll(pageable);
        return ResponseEntity.ok(clients);
    }
>>>>>>> origin/main
}
