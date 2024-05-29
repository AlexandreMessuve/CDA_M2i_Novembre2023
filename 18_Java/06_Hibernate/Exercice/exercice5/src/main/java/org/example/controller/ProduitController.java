package org.example.controller;

import org.example.entity.Produit;
import org.example.service.ProduitService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProduitController {
    private static final ProduitService produitService = new ProduitService();
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1.Ajout de prodruit");
            System.out.println("2.Voir les produits");
            System.out.println("0.Retour");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    createProduit(scanner);
                    break;
                case 2:
                    showProduits();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void createProduit(Scanner scanner){
        System.out.println("Marque du produit");
        String marque = scanner.nextLine();
        System.out.println("Ref du produit");
        String ref = scanner.nextLine();
        System.out.println("Stock du produit");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Prix du produit");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Date achat format: YYYY/MM/DD");
        String date = scanner.nextLine();
        Produit produit = new Produit();
        produit.setMarque(marque);
        produit.setReference(ref);
        produit.setPrix(prix);
        produit.setStock(stock);
        produit.setDateAchat(new Date(date));
        if(produitService.create(produit)){
            System.out.println("Creer avec succés \n" + produit);
        };
        System.out.println("Voulez vous ajouter une ou des images ? y/N");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("y")){
            System.out.println("Combien d'image voulez vous ajouter ?");
            int nbImages = scanner.nextInt();
            scanner.nextLine();
            for(int i=0; i<nbImages; i++){
                ImageController.createImage(produit);
            }
        }
    }
    public static void showProduits(){
        List<Produit> produits = produitService.findAll();
        produits.forEach(System.out::println);
    }
}
