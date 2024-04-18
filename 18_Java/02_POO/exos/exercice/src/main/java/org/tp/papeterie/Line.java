package org.tp.papeterie;

import java.util.UUID;

public class Line {
    private final UUID articleRef;
    private int quantity;
    public Line(UUID articleRef, int quantity) {
        this.articleRef = articleRef;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        Article article = BDD.getArticle(articleRef);
        double total = 0;
        if (article instanceof Stylo || article instanceof Ramette) {
            ArticleUnitaire articleUnitaire = (ArticleUnitaire) article;
            total = articleUnitaire.getPrice() * quantity;
        }
        if (article instanceof Lot lot) {
            total = (lot.getQuantity() * lot.getArticle().getPrice()) * quantity;
            total -= (total * (lot.getPourcentRemise()/100));
        }
        return total;
    }
    @Override
    public String toString() {
        Article article = BDD.getArticle(articleRef);
        ArticleUnitaire articleUnitaire = null;
        if (article instanceof Stylo || article instanceof Ramette) {
            articleUnitaire = (ArticleUnitaire) article;
        }else if (article instanceof Lot lot) {
            articleUnitaire = lot.getArticle();
        }
        assert articleUnitaire != null;
        return "Quantité : " + quantity + "\n " +
                "Réf: " + articleUnitaire.getRef() + "\n" +
                "Nom: " + articleUnitaire.getName() + "\n" +
                "Prix unitaire:  " + articleUnitaire.getPrice() + "€\n" +
                "Prix total:  " + getTotalPrice();
    }
}
