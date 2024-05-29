package exercice.zoo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Animal {
    private int id;
    private String name;
    private String type;
    private int age;
    private String description;
    private String habitat;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
