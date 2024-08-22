package com.example.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDto {
    private Long id;
    private String name;
    private String username;
}
