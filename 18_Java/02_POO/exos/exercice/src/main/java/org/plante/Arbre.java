package org.plante;

public class Arbre extends Plante{
    private double circumTrunk;

    public Arbre(String nome, int height, String colorLeaf, double circumTrunk) {
        super(nome, height, colorLeaf);
        this.circumTrunk = circumTrunk;
    }

    public double getCircumTrunk() {
        return circumTrunk;
    }

    public void setCircumTrunk(double circumTrunk) {
        this.circumTrunk = circumTrunk;
    }

    @Override
    public String toString() {
        return super.toString() + " Circonférence du tronc: " + circumTrunk;
    }
}
