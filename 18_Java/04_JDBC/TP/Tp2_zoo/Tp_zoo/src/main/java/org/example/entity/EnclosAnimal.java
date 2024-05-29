package org.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnclosAnimal {
    private int id;
    private int id_enclos;
    private int id_animal;
}
