package org.example.controller;

import org.example.entity.Commentaire;
import org.example.entity.Produit;
import org.example.service.CommentaireService;
import org.example.service.ProduitService;

import java.util.List;
import java.util.Scanner;

public class CommentaireController {
    private static final CommentaireService commentaireService = new CommentaireService();
    private static final ProduitService produitService = new ProduitService();
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1.Ajouter un commentaire");
            System.out.println("2.Retirer un commentaire");
            System.out.println("3.Voir les commentaires");
            System.out.println("0.Retour");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    createCommentaire(scanner);
                    break;
                case 2:
                    deleteCommentaire(scanner);
                    break;
                case 3:
                    showCommentaires();
                    break;
                case 0:
                    return;
            }
        }

    }

    public static void createCommentaire(Scanner scanner) {
        ProduitController.showProduits();
        Produit produit = null;
        while (produit == null){
            System.out.println("Veuillez entrer l'id d'un produit :");
            int id = scanner.nextInt();
            scanner.nextLine();
            produit = produitService.findById(id);
        }
        System.out.println("Veuillez entrer le contenu du commentaire");
        String contenu = scanner.nextLine();
        System.out.println("Veuillez saisir la note du produit "+produit.getMarque()+ " "+produit.getReference()+ "de 0 à 5");
        int note = scanner.nextInt();
        while (note < 0 || note > 5) {
            System.out.println("Veuillez mettre une note entre 0 et 5");
            note = scanner.nextInt();
        }
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(contenu);
        commentaire.setNote(note);
        commentaire.setProduit(produit);
        if(commentaireService.create(commentaire)){
            System.out.println("Commentaire ajouté " + commentaire);
        };
    }

    public static void createCommentaireByProduit(Produit produit) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez entrer le contenu du commentaire");
        String contenu = scanner.nextLine();
        System.out.println("Veuillez saisir la note du produit "+produit.getMarque()+ " "+produit.getReference()+ "de 0 à 5");
        int note = scanner.nextInt();
        while (note < 0 || note > 5) {
            System.out.println("Veuillez mettre une note entre 0 et 5");
            note = scanner.nextInt();
        }
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(contenu);
        commentaire.setNote(note);
        commentaire.setProduit(produit);
        if(commentaireService.create(commentaire)){
            System.out.println("Commentaire ajouté " + commentaire);
        };
    }

    public static void showCommentaires() {
        List<Commentaire> commentaires = commentaireService.findAll();
        commentaires.forEach(System.out::println);
    }
    public static void deleteCommentaire(Scanner scanner) {
        showCommentaires();
        Commentaire commentaire = null;
        while (commentaire == null){
            System.out.println("Id du commentaire a supprimer ?");
            int id = scanner.nextInt();
            scanner.nextLine();
            commentaire = commentaireService.findById(id);
        }
        if(commentaireService.delete(commentaire)){
            System.out.println("Commentaire supprimé avec succès");
        }

    }
}
