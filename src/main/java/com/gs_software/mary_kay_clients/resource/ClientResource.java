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

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        Client client = new Client(clientDto);
        clientService.save(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
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

    @GetMapping("/page")
    public ResponseEntity<Page<ClientDto>> listAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "listPerPage", defaultValue = "40") Integer listPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
    ) {
        Page<Client> clients = clientService.listAll(page, listPerPage, direction, orderBy);
        Page<ClientDto> clientDtos = clients.map(ClientDto::new);
        return ResponseEntity.ok(clientDtos);
    }
}
