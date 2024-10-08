package com.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto {
    private String name;
    private String username;
    private String password;
}
