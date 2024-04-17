package org.tp.papeterie;

public class Stylo extends ArticleUnitaire {
    private String color;

    public Stylo(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
