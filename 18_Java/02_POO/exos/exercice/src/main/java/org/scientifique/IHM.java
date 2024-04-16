package org.scientifique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IHM {
    private Scanner scanner = new Scanner(System.in);
    private final String dash = "-".repeat(30);
    private List<Worker> workerList = new ArrayList<>();
    private List<Scientifique> scientifiqueList = new ArrayList<>();
    private final String[] disciplines= {
            "Biologie",
            "Chimie",
            "Physique",
            "Mathématiques",
            "Informatique",
            "Géologie",
            "Astronomie",
            "Médecine",
            "Ingénierie",
            "Psychologie",
            "Écologie",
            "Sociologie"
    };
    private final String[] types = {
            "Sciences naturelles",
            "Sciences formelles",
            "Sciences sociales",
            "Sciences appliquées",
            "Sciences théoriques",
            "Sciences expérimentales",
            "Sciences computationnelles",
            "Sciences de terrain"
    };
    public void start(){
        menu();
    }
    private void menu(){
        int choice;
        do {
            System.out.println(dash);
            System.out.println("Bienvenue sur l'IHM d'ajout de travailleur et scientifique");
            System.out.println("1-Pour ajouter un travailleur ou un sciencitfique");
            System.out.println("2-Pour afficher les travailleur");
            System.out.println("3-Pour afficher les scientifiques");
            System.out.println("0-Pour quitter le programme");
            System.out.println(dash);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    createPerson();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println(showWorker());
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println(showScientifique());
                    break;
                case 0:
                    System.out.println("Fin du programme");
                    break;
            }
        }while (choice != 0);
    }
    private void createPerson(){
        System.out.println(dash);
        System.out.println();

        String choice = control("Veuillez saisir 1 pour travailleur ou 2 pour scientifique",
                "[1-2]" );
        System.out.println(dash);
        String lastname = control("Veuillez saisir le nom",
                "[A-Za-z]+");
        String firstname = control("Veuillez saisir le prenom",
                "[A-Za-z]+");
        String email = control("Veuillez saisir l' email", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        String phone = control("Veuillez saisir le telephone", "[0-9]{10}");
        String enterpriseName = control("Veuillez saisir le nom de de l' entreprise","[A-Za-z]+");
        String addressEnterprise = control("Veuillez saisir l'adresse de l' entreprise","[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)+");
        String phonePro = control("Veuilllez saisir le numéro de téléphone professionnel",  "[0-9]{10}");
        if(choice.equals("1")){
            Worker worker = new Worker(lastname, firstname, email, phone, enterpriseName, addressEnterprise, phonePro);
            System.out.println("Ajout du travailleur avec succés");
            workerList.add(worker);
        }else{
            List<String> discipline = controlArray("Veuillez saisir les discipline", disciplines);
            List<String> type =  controlArray("Veuillez saisir les types de scientifique", types);
            Scientifique scientifique = new Scientifique(lastname,firstname,email,phone,enterpriseName,addressEnterprise,phonePro,discipline,type);
            System.out.println("Ajout du scientifique avec succés");
            scientifiqueList.add(scientifique);
        }
    }
    private String control(String message, String regex){
        System.out.println(message);
        String choice = scanner.nextLine();
        while (!Pattern.matches(regex,choice)){
            System.out.printf("Erreur ! %s", message);
            choice = scanner.nextLine();
        }
        return choice;
    }

    private List<String> controlArray(String message,  String[] array){
        List<String> newArray = new ArrayList<>();
        String choice = "n";

        while (!choice.equalsIgnoreCase("y")){
            int index = 0;
            for(var item : array){
                System.out.println((index++)+"-"+item);
            }
            String choiceArray = control(message, "[0-9]+");
            if(Integer.parseInt(choiceArray) < array.length){
                newArray.add(array[Integer.parseInt(choiceArray)]);
                System.out.println(dash);
                System.out.print("Voulez vous arreter la saisie ? y/N");
                choice = scanner.nextLine();
            }else{
                System.out.println("Impossible car le numéro que vous avez saisie n'est pas possible");
            }
            System.out.println(dash);
        }
        return newArray;
    }

    private String showWorker(){
        if(workerList.isEmpty()){
            return "Aucun travailleur";
        }
        return Arrays.toString(workerList.toArray());
    }
    private String showScientifique(){
        if(scientifiqueList.isEmpty()){
            return "Aucun scientifique";
        }
        return Arrays.toString(scientifiqueList.toArray());
    }

}
