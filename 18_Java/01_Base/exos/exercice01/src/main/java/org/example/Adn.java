package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adn {
    public static void main(String[] args) {
        String chaineAdn = saisieChaineAdn("Saisir la chaine : ");
        String sequence = saisieChaineAdn("Saisir la séquence : ");

        System.out.println("chaine : " + chaineAdn);
        System.out.println("sequence : " + sequence);

        double pourcent = pourcentageSequence(chaineAdn, sequence);
        System.out.println("Pourcentage : " + pourcent);
    }

    public static boolean verificationAdn(String chaineAdn){
        //première version
//        for(int i = 0; i < chaineAdn.length(); i++){
//            if(!"actg".contains(Character.toString(chaineAdn.charAt(i))))
//                return false;
//        }
        //seconde version

        // convertis la chaine en tableau
        String[] chaineAdnSplit = chaineAdn.split("");
        for(var charAdn : chaineAdnSplit){
            if(!"actg".contains(charAdn)){
                return false;
            }
        }
        return true;
    }

    public static String saisieChaineAdn(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String chaine = scanner.nextLine().trim().toLowerCase();
        while(!verificationAdn(chaine)){
            System.out.println("Erreur ! " + message);
            chaine = scanner.nextLine().trim().toLowerCase();
        }
        return chaine;
    }

    public static double pourcentageSequence(String chaine, String sequence){
        Pattern pattern = Pattern.compile(sequence);
        Matcher matcher = pattern.matcher(chaine);
        int occurrences = 0;

        // tant qu'il y a la sequence dans la chaine de caractère l'occurences s'incrémente de 1
        while (matcher.find()) {
            occurrences++;
        }
        return (double) occurrences * sequence.length() / chaine.length() * 100;
    }
}
