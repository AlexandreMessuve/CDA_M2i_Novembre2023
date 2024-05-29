package org.example.Demo2.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Plante {
    private int id_plante;
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Plante{" +
                "id_plante=" + id_plante +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
