package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Column(unique = true)
    private String isbn;
    @Column(name = "publish_date")
    private LocalDate publishDate;
    @Column(name = "author_id")
    private Long authorId;
}
