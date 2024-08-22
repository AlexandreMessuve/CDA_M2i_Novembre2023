package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorGetDto {
    private Long id;
    private String name;
    private String biography;
    private LocalDate birthDate;
}
