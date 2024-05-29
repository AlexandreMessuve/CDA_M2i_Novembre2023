package org.example.util.Ihm;

import java.util.Scanner;

public class Ihm {
    private Scanner scanner;

    private AnimalIhm animalIhm;

    private MealIhm mealIhm;

    private EnclosIhm enclosIhm;

    public Ihm (){
        scanner = new Scanner(System.in);
        animalIhm = new AnimalIhm(scanner);
        mealIhm = new MealIhm(scanner);
        enclosIhm = new EnclosIhm(scanner);
    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Application gestion de zoo ---");
            System.out.println("1/ menu animal");
            System.out.println("2/ menu meal");
            System.out.println("3/ menu enclos");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    animalIhm.start();
                    break;
                case 2:
                    mealIhm.start();
                    break;
                case 3:
                    enclosIhm.start();
                    break;
                default:
                    return;
            }
        }
    }
}
