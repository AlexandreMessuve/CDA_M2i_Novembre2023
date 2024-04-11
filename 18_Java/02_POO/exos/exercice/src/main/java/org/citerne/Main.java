package org.citerne;

public class Main {
    public static void main(String[] args) {
        Citerne watertank1 = new Citerne(10, 20, 10);
        Citerne watertank2 = new Citerne(5, 10, 10);

        System.out.println("Poids total de la citerne 1 : " + watertank1.getTotalWeight());
        System.out.println("Poids total de la citerne 2 : " + watertank2.getTotalWeight());

        System.out.println("----------------------");

        System.out.println("Quantité d'eau dans la citerne 1 : " + watertank1.getFillingRate());
//        watertank1.affichageCiterne();
        System.out.println("Quantité d'eau dans la citerne 2 : " + watertank2.getFillingRate());
//        watertank2.affichageCiterne();
        System.out.println("Quantité d'eau dans toutes les citernes : " + Citerne.getFillingRateCiterne());

        System.out.println("----------------------");

        int excessWater = watertank1.addFillingRate(11);
        System.out.println("Quantité d'eau dans la citerne 1 après ajout de 11 litres: " + watertank1.getFillingRate() + "/" + watertank1.getMaxCapacity());
        System.out.println("Excès d'eau récupéré : " + excessWater);

        int waterTaken = watertank2.emptyFillingRate(11);
        System.out.println("Quantité d'eau dans la citerne 2 après tentative de retrait de 11 litres: " + watertank2.getFillingRate() + "/" + watertank2.getMaxCapacity());
        System.out.println("Quantité d'eau récupérée : " + waterTaken);

        System.out.println("----------------------");

        System.out.println("Quantité d'eau dans la citerne 1 : " + watertank1.getFillingRate());
//        watertank1.affichageCiterne();
        System.out.println("Quantité d'eau dans la citerne 2 : " + watertank2.getFillingRate());
//        watertank2.affichageCiterne();
        System.out.println("Quantité d'eau dans toutes les citernes : " + Citerne.getFillingRateCiterne());
    }
}
