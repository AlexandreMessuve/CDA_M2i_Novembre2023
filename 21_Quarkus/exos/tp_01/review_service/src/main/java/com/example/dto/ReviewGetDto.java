package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewGetDto {
    private Long id;
    private String comment;
    private int rating;
    private BookDto book;
    private UserDto user;
}
