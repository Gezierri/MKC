package com.gs_software.mary_kay_clients.entity.dto;

import com.gs_software.mary_kay_clients.entity.Address;
import com.gs_software.mary_kay_clients.entity.Client;
import java.time.LocalDate;

public record ClientDto(
        Long id,
        String name,
        String phone,
        LocalDate dateBirth,
        Address address
) {
    public ClientDto(Client client) {
        this(client.getId(), client.getName(), client.getPhoneNumber(), client.getDateBirth(), client.getAddress());
    }
}

