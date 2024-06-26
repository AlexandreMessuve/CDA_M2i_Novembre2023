package org.tp.papeterie;

public abstract class ArticleUnitaire extends Article {
    protected String name;
    protected double price;
    public ArticleUnitaire(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ref : " + ref + " : " + name + " : " + price +"€ ";
    }
}
