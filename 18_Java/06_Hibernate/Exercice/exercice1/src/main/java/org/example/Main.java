package org.example;

import org.example.entity.Produit;
import org.example.service.ProduitService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Exercice 1
      //  - Créer cinq produits,

        ProduitService ps = new ProduitService();

        /*
        ps.create(new Produit("Apple","i5685",1500,199,new Date("2024/05/20")));
        ps.create(new Produit("Samsung","s7985",800,85,new Date("2024/01/10")));
        ps.create(new Produit("DELL","d5685",300,75,new Date("2023/07/20")));
        ps.create(new Produit("Huawei","hu568",20,800,new Date("2022/12/22")));
        ps.create(new Produit("Nokia","3310",50,89,new Date("2024/05/10")));

         */

      //  - Afficher les informations du produit dont id = 2,

        Produit p = ps.findById(2);
        System.out.println(p);


      //  - Supprimer le produit dont id = 3,

      //  ps.delete(ps.findById(3));
      //  - Modifier les informations du produit dont id = 1,

        Produit p1 = ps.findById(1);
        if(p1 != null){
            p1.setPrix(2000);
            ps.update(p1);
        }


        ps.close();
    }
}