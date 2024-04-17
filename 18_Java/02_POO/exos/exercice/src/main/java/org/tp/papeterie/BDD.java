package org.tp.papeterie;

import java.util.HashMap;

public class BDD {
    private static HashMap<String, Article> articles = new HashMap<>();

    public static Article getArticle(String id) {
        return articles.get(id);
    }
    public static void addArticle(Article article) {
        articles.put(article.getId(), article);
    }
    public static void removeArticle(String id) {
        articles.remove(id);
    }
    public static HashMap<String, Article> getArticles() {
        return articles;
    }
}
