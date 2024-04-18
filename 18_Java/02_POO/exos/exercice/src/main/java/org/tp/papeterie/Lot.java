package org.tp.papeterie;

import java.util.UUID;

public class Lot extends Article{
    private final UUID articleRef;
    private final int quantity;
    private final double pourcentRemise;

    public Lot(UUID articleRef, int quantity, double pourcentRemise) {
        super();
        this.articleRef = articleRef;
        this.quantity = quantity;
        this.pourcentRemise = pourcentRemise;
    }

    public ArticleUnitaire getArticle() {
        return (ArticleUnitaire) BDD.getArticle(articleRef);
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPourcentRemise() {
        return pourcentRemise;
    }
}
