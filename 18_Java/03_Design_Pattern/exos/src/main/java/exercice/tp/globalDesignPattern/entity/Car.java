package exercice.tp.globalDesignPattern.entity;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class Car extends Vehicle {
    private String name;
    private int position;
    private int speed;
    private int weight;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", speed=" + speed +
                ", weight=" + weight +
                "} ";
    }
}
