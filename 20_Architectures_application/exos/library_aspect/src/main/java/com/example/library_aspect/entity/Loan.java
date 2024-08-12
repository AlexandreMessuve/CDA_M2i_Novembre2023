package com.example.library_aspect.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {
    private int id;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private boolean rendered;
    private Book book;
}
