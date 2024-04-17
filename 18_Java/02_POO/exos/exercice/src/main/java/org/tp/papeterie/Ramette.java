package org.tp.papeterie;

public class Ramette extends ArticleUnitaire {
    private double weight;

    public Ramette(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
