package org.exercice;

public class Chaise {
    private int pieds;
    private String materials;
    private String color;
    private double price;

    public Chaise(){
        this(2,"métal","noir",19.99);
    }

    public Chaise(int pieds,String materials, String color, double price) {
        this.pieds = pieds;
        this.materials = materials;
        this.color = color;
        this.price = price;
    }

    public String toString(){
        return "Je suis une chaise avec " +
                this.pieds +
                " pied(s) en " +
                this.materials+
                " de couleur "+
                this.color +
                " à un prix de " +
                this.price;
    }
}
