package org.tp.papeterie;

public class Lot extends Article{
    private ArticleUnitaire article;
    private int quantity;
    private double pourcentRemise;

    public Lot(ArticleUnitaire article, int quantity, double pourcentRemise) {
        super();
        this.article = article;
        this.quantity = quantity;
        this.pourcentRemise = pourcentRemise;
    }

    public ArticleUnitaire getArticle() {
        return article;
    }

    public void setArticle(ArticleUnitaire article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPourcentRemise() {
        return pourcentRemise;
    }

    public void setPourcentRemise(double pourcentRemise) {
        this.pourcentRemise = pourcentRemise;
    }
}
