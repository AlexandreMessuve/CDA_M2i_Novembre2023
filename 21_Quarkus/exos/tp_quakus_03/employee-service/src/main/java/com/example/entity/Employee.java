package com.example.entity;

import com.example.dto.DepartmentDto;
import com.example.dto.OrganizationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String position;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "organization_id")
    private Long organizationId;

    @Transient
    private DepartmentDto department;

    @Transient
    private OrganizationDto organization;
}
