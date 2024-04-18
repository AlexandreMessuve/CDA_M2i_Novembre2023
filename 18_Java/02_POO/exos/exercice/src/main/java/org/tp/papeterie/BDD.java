package org.tp.papeterie;

import java.util.HashMap;
import java.util.UUID;

public class BDD {
    private static HashMap<UUID, Article> articles = new HashMap<>();
    private static HashMap<UUID, Facture> factures = new HashMap<>();

    public static HashMap<UUID, Facture> getFactures() {
        return factures;
    }
    public static Facture getFacture(UUID id) {
        return factures.get(id);
    }
    public static void addFactures(UUID id, Facture facture) {
        BDD.factures.put(id, facture);
    }

    public static Article getArticle(UUID ref) {
        return articles.get(ref);
    }
    public static void addArticle(UUID ref, Article article) {
        articles.put(article.getRef(), article);
    }
    public static HashMap<UUID, Article> getArticles() {
        return articles;
    }

}
