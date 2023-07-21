package com.gs_software.mary_kay_clients.entity;

import com.gs_software.mary_kay_clients.entity.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public Product(ProductDto productDto) {
        this.id = productDto.id();
        this.name = productDto.name();
        this.description = productDto.description();
        this.price = productDto.price();
        this.stock = productDto.stock();
    }
}
