package com.gs_software.mary_kay_clients.entity.dto;

import java.time.LocalDate;

public record ClientDto(
        Long id,
        String name,
        String phone,
        LocalDate dateBirth
) {
}
