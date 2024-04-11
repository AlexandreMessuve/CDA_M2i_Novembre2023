package org.exercice;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Exercice chaise
        Chaise chaise01 = new Chaise();
        Chaise chaise02 = new Chaise(4, "chaine", "bleu", 14.4);
        Chaise chaise03 = new Chaise(1, "bambou", "orange", 130.99);

        System.out.println(chaise01);
        System.out.println(chaise02);
        System.out.println(chaise03);


        //Exercice Film
        Film film01 = new Film("La haine", "Mathieu Kassovitz", LocalDate.of(1995,05,31), "Drame");
        Film film02 = new Film("La haine", "Mathieu Kassovitz", LocalDate.of(2022,12,14), "Drame");

        System.out.println(film01);
        System.out.println(film02);


        //Exercice joueur
        Joueur joueur = new Joueur("WarriorDu59");
        int i = 1;
        do{
            System.out.println("Le joueur " + joueur.getName() + " effectue la quête n°"+ (i));
            joueur.quest();
            i++;
        }while (joueur.getLevel() < 5);
        joueur.setName("LeGigaBossDuJava");
    }
}