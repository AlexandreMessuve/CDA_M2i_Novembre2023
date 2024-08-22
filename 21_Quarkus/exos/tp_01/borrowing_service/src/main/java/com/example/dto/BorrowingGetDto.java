package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingGetDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookDto book;
    private UserDto user;
}
