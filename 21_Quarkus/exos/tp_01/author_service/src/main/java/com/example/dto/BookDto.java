package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long bookId;
    private String title;
    private String description;
    private String isbn;
    private LocalDate publishedDate;
    private Long authorId;
}
