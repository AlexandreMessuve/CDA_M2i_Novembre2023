package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(name = "number_of_employees")
    private int numberOfEmployees;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_last_joined_or_left_employee")
    private LocalDateTime dateLastJoinedOrLeftEmployee;

}
