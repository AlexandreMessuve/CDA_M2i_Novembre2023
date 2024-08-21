package com.example.dto;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGetDto {
    private Long id;
    private int quantity;
    private LocalDate orderDate;
    private ProductDto product;
    private ClientDto client;

}
