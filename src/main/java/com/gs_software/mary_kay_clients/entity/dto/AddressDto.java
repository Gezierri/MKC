package com.gs_software.mary_kay_clients.entity.dto;

public record AddressDto(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String postalCode,
        String country
) {
}
