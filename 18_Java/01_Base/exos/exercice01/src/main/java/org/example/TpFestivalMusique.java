package org.example;

import java.util.Scanner;

public class TpFestivalMusique {
    public static void main(String[] args) {
        // tp festival
        int maxEndurance = 100;
        int endurance = maxEndurance;
        int tps = 100;
        String userExperience = "";
        userExperience = menu(maxEndurance, endurance, tps, userExperience);
        System.out.println("Merci d'avoir participé à ce festival virtuel");
        System.out.println("Votre expérience :");
        System.out.println(userExperience);
    }

    public static String menu(int maxEndurance, int endurance, int tps, String userExperience){
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Bienvenue au festivale de musique virtuelle");
            System.out.println("sélectionnez votre scène:");
            System.out.println("[1] Jazz\n[2] Rock\n[3] Metäl\n[4] La buvette");

            //Bonus pour ajouter de l'énergie ou du temps en fonction d'une valeur random
            double randomEvent = Math.random();
            if (randomEvent > .75){
                System.out.println("Boisson énergiseante gratuite! [Energie +20]");
                endurance += 20;
                if (endurance > maxEndurance){
                    endurance = maxEndurance;
                }
            }else if (randomEvent > .50) {
                System.out.println("Les parents rentrent tard! [Temps +10]");
                tps += 10;
            }
            System.out.println("Energie : "+endurance+"\nTemps : "+tps);
            //Fin partie Bonus random

            int userInput = input.nextInt();
            switch (userInput){
                case 1:
                    userExperience += "[Jazz]";
                    System.out.println("[1] Scene 1 [Energie - 10 | Temps - 20]\n[2] Scene 2 [Energie - 15 | Temps - 10]\n");
                    userInput = input.nextInt();
                    if( userInput == 1) {
                        userExperience += " Scene 1\n";
                        endurance -= 10;
                        tps -= 20;
                    }else if( userInput == 2) {
                        userExperience += " Scene 2\n";
                        endurance -= 15;
                        tps -= 10;
                    }
                    continue;
                case 2:
                    userExperience += "[Rock]";
                    System.out.println("[1] Scene 1 [Energie - 30 | Temps - 20]\n[2] Scene 2 [Energie - 20 | Temps - 10]\n[3] Scene 3 [Energie - 25 | Temps - 25]");
                    userInput = input.nextInt();
                    if (userInput == 1) {
                        userExperience += " Scene 1\n";
                        endurance -= 30;
                        if (endurance > maxEndurance){
                            endurance = maxEndurance;
                        }
                        tps -= 20;
                    } else if (userInput == 2) {
                        userExperience += " Scene 2\n";
                        endurance -= 20;
                        tps -= 20;
                    } else  if (userInput == 3) {
                        userExperience += " Scene 3\n";
                        endurance -= 25;
                        tps -= 25;
                    }
                    continue;
                case 3:
                    userExperience += "[Metal]";
                    System.out.println("[1] Scene 1 [Energie - 40 | Temps - 15]");
                    userInput = input.nextInt();
                    if (userInput == 1) {
                        userExperience += " Scene 1\n";
                        endurance -= 40;
                        tps -= 15;
                    }
                    continue;
                case 4:
                    System.out.println("[1] Boisson énergiseante [Energie +20 | Temps - 5]\n[2] Bière [Energie -5 | Temps - 5]");
                    userInput = input.nextInt();
                    if( userInput == 1) {
                        endurance += 20;
                    }else {
                        endurance -= 5;
                    }
                    tps -= 5;
            }
        }while (endurance > 0 && tps > 0);
        return userExperience;
    }
}
