package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPostDto {
    private String title;
    private String description;
    private String isbn;
    private LocalDate publishDate;
    private Long authorId;
}
