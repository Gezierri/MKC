package com.gs_software.mary_kay_clients.entity;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
=======
>>>>>>> origin/main
import com.gs_software.mary_kay_clients.entity.dto.ClientDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
<<<<<<< HEAD

=======
>>>>>>> origin/main
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
<<<<<<< HEAD
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_birth")
=======
    private String phoneNumber;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
>>>>>>> origin/main
    private LocalDate dateBirth;
    @Embedded
    private Address address;

    public Client(ClientDto clientDto) {
        this.id = clientDto.id();
        this.name = clientDto.name();
        this.phoneNumber = clientDto.phone();
        this.dateBirth = clientDto.dateBirth();
<<<<<<< HEAD
        this.address = clientDto.address();
=======
>>>>>>> origin/main
    }
}
