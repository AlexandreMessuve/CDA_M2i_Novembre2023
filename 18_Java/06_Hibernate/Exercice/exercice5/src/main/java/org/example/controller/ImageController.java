package org.example.controller;

import org.example.entity.Image;
import org.example.entity.Produit;
import org.example.service.ImageService;

import java.util.Scanner;

public class ImageController {
    private static ImageService imageService = new ImageService();

    public static void createImage(Produit produit) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'url: ");
        String url = scanner.nextLine();
        Image image = new Image();
        image.setUrl(url);
        image.setProduit(produit);
        if (imageService.create(image)){
            System.out.println("Image ajouté avec succés" + image);
        }
    }
}
