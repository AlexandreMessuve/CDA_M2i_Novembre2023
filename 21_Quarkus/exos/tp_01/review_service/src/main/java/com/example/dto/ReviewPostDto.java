package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewPostDto {
    private String comment;
    private int rating;
    private Long bookId;
    private Long userId;
}
