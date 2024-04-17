package org.tp.papeterie;

public class Ligne {
    private Article article;
    private int quantity;
    public Ligne(String refArticle, int quantity) {
        this.article = BDD.getArticle(refArticle);
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        ArticleUnitaire articleUnitaire = (ArticleUnitaire) article;
        return "Quantité : " + quantity + "\n " +
                "Réf: " + articleUnitaire.getId() + "\n" +
                "Nom: " + articleUnitaire.getName() + "\n" +
                "Prix:  " + articleUnitaire.getPrice() +'€';
    }
}
