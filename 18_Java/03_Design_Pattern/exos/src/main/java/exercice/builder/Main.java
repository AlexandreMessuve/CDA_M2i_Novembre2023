package exercice.builder;

import exercice.builder.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> garniture = new ArrayList<>();
        garniture.add("Jambon");
        garniture.add("Champignons");
        Pizza pizza = new Pizza.PizzaBuilder().taille("Moyenne").fromage("Mozzarella").garniture(garniture).typePate("fine").sauce("tomate").build();
        System.out.println(pizza);

    }
}
