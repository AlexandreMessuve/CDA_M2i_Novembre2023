package org.example;

import javax.xml.datatype.Duration;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Exercice 01

        System.out.println("Veuillez saisir votre temperature");
        float temp = scanner.nextFloat();
        System.out.println("En quelle unité voulez vous votre température ? \n Tapez 1 pour Celsus ou 2 pour Fahrenheit");
        int unity = scanner.nextInt();
        if(unity == 1){
           temp = (temp - 32) * 5/9;
        }else{
            temp = temp * 9 / 5 + 32;
        }
        System.out.println(temp);

        // Exercice02
        float totalCoast;
        System.out.println("Combien de bonbons voulez vous acheter ?");
        int numberCandy = scanner.nextInt();
        System.out.println("Prix du bonbon ?");
        float price = scanner.nextFloat();
        totalCoast = price * numberCandy;
        System.out.println("Vous devrez payer : "+totalCoast + "€");
        scanner.close();

    }
}