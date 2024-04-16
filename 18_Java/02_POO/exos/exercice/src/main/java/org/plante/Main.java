package org.plante;

public class Main {


    public static void main(String[] args) {
        Plante plant01 = new Plante("Geranium", 10, "Rose");
        Arbre arbre = new Arbre("Sapin", 500, "Marron", 20.25);

        System.out.println(plant01);
        System.out.println(arbre);
    }
}
