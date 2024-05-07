package org.exceptions.typeincorrect;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int input = 0;
        boolean error = false;
        do {
            try {
                System.out.println("Veuillez saisir un entier !");
                input = scanner.nextInt();
            } catch (ArithmeticException e) {
                System.out.println("Ce n'est pas un entier !");
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);
        System.out.println("L'entier que vous avez saisir : ");
        System.out.println(input);

    }
}
