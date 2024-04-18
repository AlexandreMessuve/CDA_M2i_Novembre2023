package org.tp.papeterie;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class IHM {
    private Scanner scanner = new Scanner(System.in);

    public void start(){
            menu();
    }
    private void menu(){
        String choice;
        do {
            System.out.println("------------Menu principal -------------");
            System.out.println("1-Ajout d'article");
            System.out.println("2-Afficher les articles");
            System.out.println("3-Acheter articles");
            System.out.println("0-Quitter le programme");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(addArticle());
                    break;
                case "2":
                    showArticles();
                    break;
                case "3":
                    break;
                case "0":
                    break;
            }
        }while (!choice.equalsIgnoreCase("0"));
        System.out.println("------------Fin du programme-------------");
    }
    private String addArticle(){
        System.out.println("------------Ajout d'article -------------");
        System.out.println("1-Stylo");
        System.out.println("2-Ramette");
        System.out.println("3-Lot");
        Article article = null;
        int choice = Integer.parseInt(control("", "[1-3]"));
        if(choice != 3){
            String name = control("Ajouter le nom de l'article", "[A-Za-z]+");
            double price = Double.parseDouble(control("Ajouter le prix", "^\\d+(\\.\\d+)?$"));
            if(choice == 1){
                String color = control("Ajouter la couleur", "[A-Za-z]+");
                article = new Stylo(name, price, color);
            }
            else if(choice == 2){
                double weight = Double.parseDouble(control("Ajouter le poids en gramme", "^\\d+(\\.\\d+)?$" ));
                article = new Ramette(name, price, weight);
            }
        }else {
            HashMap<UUID, Article> articles = BDD.getArticles();
            if(articles.isEmpty()){
                return "Il ni a pas d'article dans la bdd";
            }
            final int[] i = {1};
            System.out.println("Choisissez un article :");
            articles.forEach((k, v) -> {
                if(v instanceof Stylo || v instanceof Ramette){
                    System.out.println(i[0] + " " +v);
                    i[0]++;
                }
            });
            do {
                choice = Integer.parseInt(control("", "[1-9]+"));
                System.out.println(choice);
            }while (choice > i[0]);
            i[0] = 1;
            AtomicReference<UUID> refArticle = new AtomicReference<>();
            int finalChoice = choice;
            articles.forEach((k, v) -> {
                if(v instanceof Stylo || v instanceof Ramette){
                    if(i[0] == finalChoice){
                        refArticle.set(v.getRef());
                    }
                    i[0]++;
                }
            });
            int quantity = Integer.parseInt(control("Veuillez saisir la quantité", "[0-9]+"));
            double remise = Double.parseDouble(control("Veuillez saisir la remise en %", "^\\d+(\\.\\d+)?$"));
            article = new Lot(refArticle.get(), quantity,remise);
        }
        assert article != null;
        BDD.addArticle(article.getRef(), article);
        return "Ajout de l'article";
    }

    private void showArticles(){
        HashMap<UUID, Article> articles = BDD.getArticles();
        if(articles.isEmpty()){
            System.out.println("Aucun article");
        }else{
            articles.forEach((k, v) -> {
                System.out.println(v);
            });
        }
    }
    private String purchaseArticles(){
        System.out.println("------------Achat d'article -------------");
        showArticles();
        return  "";
    }
    private String control(String message, String regex){
        System.out.println(message);
        String choice = scanner.nextLine();
        while (!Pattern.matches(regex,choice)){
            System.out.printf("Erreur ! %s", message);
            choice = scanner.nextLine();
        }
        return choice;
    }
}
