package com.gs_software.mary_kay_clients.entity.dto;

<<<<<<< HEAD
import com.gs_software.mary_kay_clients.entity.Address;
import com.gs_software.mary_kay_clients.entity.Client;

=======
>>>>>>> origin/main
import java.time.LocalDate;

public record ClientDto(
        Long id,
        String name,
        String phone,
<<<<<<< HEAD
        LocalDate dateBirth,
        Address address
) {
    public ClientDto(Client client) {
        this(client.getId(), client.getName(), client.getPhoneNumber(), client.getDateBirth(), client.getAddress());
    }
=======
        LocalDate dateBirth
) {
>>>>>>> origin/main
}
