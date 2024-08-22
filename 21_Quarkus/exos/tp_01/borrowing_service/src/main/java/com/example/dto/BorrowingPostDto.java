package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingPostDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long bookId;
    private Long userId;
}
