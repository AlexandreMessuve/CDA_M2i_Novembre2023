package org.example;

import org.example.entity.Produit;
import org.example.service.ProduitService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Exercice 1
      //  - Créer cinq produits,

        ProduitService ps = new ProduitService();


//        ps.create(new Produit("Apple","i5685",1500,199,new Date("2024/05/20")));
//        ps.create(new Produit("Samsung","s7985",800,85,new Date("2024/01/10")));
//        ps.create(new Produit("DELL","d5685",300,75,new Date("2023/07/20")));
//        ps.create(new Produit("Huawei","hu568",20,800,new Date("2022/12/22")));
//        ps.create(new Produit("Nokia","3310",50,89,new Date("2024/05/10")));



      //  - Afficher les informations du produit dont id = 2,

      //  Produit p = ps.findById(2);
      //  System.out.println(p);


      //  - Supprimer le produit dont id = 3,

      //  ps.delete(ps.findById(3));
      //  - Modifier les informations du produit dont id = 1,


//        Produit p1 = ps.findById(1);
//        if(p1 != null){
//            p1.setPrix(2000);
//            ps.update(p1);
//        }



        // Exercice 2

       // 1. Afficher la totalité des produits

//        List<Produit> produitList = ps.findAll();
//        for (Produit p: produitList){
//            System.out.println(p);
//        }

      //  2. Afficher la liste des produits dont le prix est supérieur à 100 euros

//        try {
//            List<Produit> produitList1 = ps.filterByPrice(100);
//            for (Produit p: produitList1){
//                System.out.println(p);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }


      //  3. Afficher la liste des produits achetés entre deux dates.
//        try {
//            List<Produit> produitList2 = ps.filterByDate(new Date("2021/01/01"),new Date("2023/01/01"));
//            for (Produit p: produitList2){
//                System.out.println(p);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        // Exercice 3

       // 1. Afficher la liste des produits commandés entre deux dates lus au clavier.


//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Veuillez saisir une premiere date (dd/MM/yyyy) :");
//            String s1 = scanner.nextLine();
//            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(s1);
//            System.out.println("Veuillez saisir une premiere date (dd/MM/yyyy) :");
//            String s2 = scanner.nextLine();
//            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(s2);
//            List<Produit> produitList3 = ps.filterByDate(date1,date2);
//            for (Produit p: produitList3){
//                System.out.println(p);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }


      //  2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Veuillez saisir le stock max :");
//            int max = scanner.nextInt();
//            List<Produit> produitList4 = ps.filterByStockMax(max);
//            for (Produit p: produitList4){
//                System.out.println(p);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        //Exercice 4

        //1. Afficher la valeur du stock des produits d'une marque choisie
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez saisir le nom de la marque");
            String marque = scanner.nextLine();
            double value = ps.stockValueByMarque(marque);
            System.out.println("La valeur du stock de la marque " + marque+ " : " + value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //2. Calculer le prix moyen des produits.
        try {
            double avgPrice = ps.produitPriceMoy();
            System.out.println("Le prix moyen des produit :"+avgPrice);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Afficher les produits d'une marque


        //ps.create(new Produit("Apple","i5784",1250,120,new Date("2019/11/20")));
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez saisir le nom de la marque");
            String marque = scanner.nextLine();
            List<Produit> produitList = ps.produitByMarque(marque);
            produitList.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Supprimer les produits d'une marque
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez saisir le nom de la marque");
            String marque = scanner.nextLine();
            if (ps.deleteProduitByMarque(marque)){
                System.out.println("Deleted Successfully");
            }
            List<Produit> produitList = ps.findAll();
            produitList.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ps.close();
    }
}