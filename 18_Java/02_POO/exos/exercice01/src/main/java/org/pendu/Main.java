package org.pendu;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }
    public static void start() {
        String word = WordGenerator.generateWord();
        Pendu pendu = new Pendu(word);
        pendu = menu(pendu);

        if (pendu.testWin()) {
            System.out.printf("Vous avez gagné ! le mot : %s", pendu.getWord());
        } else {
            System.out.printf("Vous avez perdu ! le mot : %s", pendu.getWord());
        }
    }

    private static Pendu menu(Pendu pendu) {
        System.out.print("Voulez vous definir le nombre d'essai ? (10 par defaut) ? Y/N ");
        char choice = scanner.next().toLowerCase().charAt(0);
        if (choice == 'y') {
            System.out.print("Combien d'essai voulez vous ?");
            int essai = scanner.nextInt();
            pendu.setCount(essai);
        }
        do {
            System.out.printf("%s (%s lettres) essai restant %s\n", pendu.getMaskedWord(), pendu.getMaskedWord().length(), pendu.getCount());
            System.out.print("Entrez une lettre : ");
            String yourChar = scanner.nextLine();
            pendu.testChar(yourChar.toLowerCase());
        } while (pendu.getCount() != 0 || !pendu.testWin());
        return pendu;
    }

}
