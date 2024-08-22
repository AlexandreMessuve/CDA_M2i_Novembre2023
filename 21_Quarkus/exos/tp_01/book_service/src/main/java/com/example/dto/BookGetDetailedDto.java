package com.example.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookGetDetailedDto {
    private Long bookId;
    private String title;
    private String description;
    private String isbn;
    private LocalDate publishDate;
    private AuthorDto author;
}
