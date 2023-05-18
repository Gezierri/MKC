package com.gs_software.mary_kay_clients.entity;


import com.gs_software.mary_kay_clients.entity.dto.ClientDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NumberFormat(pattern = "###########")
    private String phoneNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBirth;
    @Embedded
    private Address address;

    public Client(ClientDto clientDto) {
        this.id = clientDto.id();
        this.name = clientDto.name();
        this.phoneNumber = clientDto.phone();
        this.dateBirth = clientDto.dateBirth();
    }
}
