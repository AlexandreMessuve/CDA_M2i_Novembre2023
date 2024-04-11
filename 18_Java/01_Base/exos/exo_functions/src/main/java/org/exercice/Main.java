package org.exercice;

public class Main {

    public static void main(String[] args) {
        // exo nom complet
        System.out.println(completeName("Alexandre", "Messuve"));

        //exo soustraction
        System.out.println(substract(1,2));

        //exo quelle heure
        whatHour();
        whatHour("10h00");

        //exo compteur de lettre
        int count1 = countLetterA("C'est le b-a ba");
        int count2 = countLetterA("mixer");
        System.out.println(count1);
        System.out.println(count2);
    }
    public static String completeName(String firstname, String lastname){
        return firstname+ ' ' + lastname;
    }
    public static int substract(int int1, int int2){
        System.out.println("Je soustrait " + int1 +" et " + int2);
        return int1 - int2;
    }
    public static void whatHour(String hour){
        System.out.println("Il est " + hour);
    }
    public static void whatHour(){
        System.out.println("Il est 12h00");
    }
    public static int countLetterA(String myString) {
        //initialisation du compteur à 0
        int countA = 0;

        //transformation de la chaine de caractère en tableau
        String[] myStringSplit = myString.split("");

        //for each qui parcours le tableau
        for(var myChar : myStringSplit){

            // condition si il y a la lettre a dans la chaine increment le compteur + 1
            if(myChar.equalsIgnoreCase("a")){
                countA++;
            }
        }
        //retourne le compteur
        return countA;
    }
}