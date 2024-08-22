package com.example.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorGetDetailDto {
    private Long id;
    private String name;
    private String biography;
    private LocalDate birthDate;
    private List<BookDto> booksPublished;
}
