package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String biography;
    private LocalDate birthDate;
}
