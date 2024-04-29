package exercice.builder.model;

import java.util.List;

public class Pizza {
    String taille;
    String typePate;
    String fromage;
    List<String> garnitures;
    String sauce;

    private Pizza(PizzaBuilder builder) {
        this.taille = builder.taille;
        this.typePate = builder.typePate;
        this.fromage = builder.fromage;
        this.garnitures = builder.garnitures;
        this.sauce = builder.sauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "taille='" + taille + '\'' +
                ", typePate='" + typePate + '\'' +
                ", fromage='" + fromage + '\'' +
                ", garnitures=" + garnitures +
                ", sauce='" + sauce + '\'' +
                '}';
    }

    public static class PizzaBuilder {
        private String taille;
        private String typePate;
        private String fromage;
        private List<String> garnitures;
        private String sauce;

        public PizzaBuilder taille(String taille) {
            this.taille = taille;
            return this;
        }
        public PizzaBuilder typePate(String typePate) {
            this.typePate = typePate;
            return this;
        }
        public PizzaBuilder fromage(String fromage) {
            this.fromage = fromage;
            return this;
        }
        public PizzaBuilder garniture(List<String> garnitures) {
            this.garnitures = garnitures;
            return this;
        }
        public PizzaBuilder sauce(String sauce) {
            this.sauce = taille;
            return this;
        }
        public Pizza build() {
            return new Pizza(this);
        }
    }
}
