package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.entity.dto.ClientDto;
import com.gs_software.mary_kay_clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("clients")
@RestController
@RequiredArgsConstructor
@CrossOrigin
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
    public ResponseEntity<List<ClientDto>> findByNameContaining(@RequestParam String name) {
        List<Client> clients = clientService.findByNameContaining(name);
        List<ClientDto> clientsDto = clients.stream().map(ClientDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(clientsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long id) {
        Client client = clientService.findClientById(id);
        ClientDto clientDto = new ClientDto(client);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto, @PathVariable Long id){
        Client client = clientService.updateClient(new Client(clientDto), id);
        return ResponseEntity.ok(new ClientDto(client));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ClientDto>> listAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "listPerPage", defaultValue = "5") Integer listPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
    ) {
        Page<Client> clients = clientService.listAll(page, listPerPage, direction, orderBy);
        Page<ClientDto> clientDtos = clients.map(ClientDto::new);
        return ResponseEntity.ok(clientDtos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }
}
