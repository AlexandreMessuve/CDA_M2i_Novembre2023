package org.example.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class Enclos {
    private int id;
    private String name;
    private List<Animal> animals;
}
