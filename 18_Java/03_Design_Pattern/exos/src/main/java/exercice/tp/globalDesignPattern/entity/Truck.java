package exercice.tp.globalDesignPattern.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Truck extends Vehicle{
    private String name;
    private int position;
    private int speed;
    private int weight;

    @Override
    public String toString() {
        return "Truck{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", speed=" + speed +
                ", weight=" + weight +
                "} ";
    }
}
