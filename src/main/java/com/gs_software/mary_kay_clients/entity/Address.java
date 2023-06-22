package com.gs_software.mary_kay_clients.entity;

import com.gs_software.mary_kay_clients.entity.dto.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(AddressDto addressDto) {
        this.street = addressDto.street();
        this.complement = addressDto.complement();
        this.neighborhood = addressDto.neighborhood();
        this.state = addressDto.state();
        this.postalCode = addressDto.postalCode();
        this.country = addressDto.country();
        this.number = addressDto.number();
    }
}


