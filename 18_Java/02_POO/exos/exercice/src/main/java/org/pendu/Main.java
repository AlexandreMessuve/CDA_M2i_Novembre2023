package org.pendu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }
    public static void start() {
        String word = WordGenerator.generateWord();
        Pendu pendu = new Pendu(word);
        pendu = menu(pendu);
        System.out.println("-".repeat(30));
        if (pendu.testWin()) {
            System.out.printf("Vous avez gagné ! le mot : %s", pendu.getWord());
        } else {
            System.out.printf("Vous avez perdu ! le mot : %s", pendu.getWord());
        }
    }

    private static Pendu menu(Pendu pendu) {
        System.out.print("Voulez vous definir le nombre d'essai ? (10 par defaut) ? Y/N ");
        char choice = scanner.next().toLowerCase().charAt(0);
        int essai;
        if (choice == 'y') {
            System.out.print("Combien d'essai voulez vous ?");
            while (true) {
                try {
                    essai = Integer.parseInt(scanner.next());
                    if(essai < 0){
                        throw new Exception("N'est pas positif");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Ce n'est pas un entier");
                    continue;
                }catch (Exception e){
                    System.out.println("Saisie incorrect (négative)");
                    continue;
                }
                break;
            }
            pendu.setCount(essai);
        }
        do {

            System.out.printf("Mot à trouvée : %s (%s lettres) \n Essai restant: %s\n", pendu.getMaskedWord(), pendu.getMaskedWord().length(), pendu.getCount());
            System.out.print("Entrez une lettre : ");
            String yourChar = scanner.nextLine();
            while (!Pattern.matches("[A-Za-z]", yourChar)){
                System.out.print("Erreur ! veuillez reesayer : ");
                yourChar = scanner.nextLine();
            }
            String resp = pendu.testChar(yourChar.toLowerCase());
            System.out.println("-".repeat(30));
            System.out.println(resp);
        } while (pendu.getCount() != 0 && !pendu.testWin());
        return pendu;
    }

}
