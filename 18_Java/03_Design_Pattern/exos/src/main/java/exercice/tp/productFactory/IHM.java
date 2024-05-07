package exercice.tp;

import exercice.tp.entity.*;
import exercice.tp.factory.BicycleFactory;
import exercice.tp.factory.ComputerFactory;

import java.util.*;
import java.util.regex.Pattern;

public class IHM {
    private Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();

    public void start(){
        this.menu();
    }

    private void menu(){
        System.out.println("Bienvenue dans le programme");
        String choice;
        do {
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Liste des produits");
            System.out.println("3. Quitter");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    showProductList();
                    break;
                default:
                    break;
            }
        }while (!choice.equalsIgnoreCase("3"));
        System.out.println("Fin du programme");
    }
    private void addProduct(){
        String choice;
        do {
            System.out.println("Quelle type de produit voulez vous ajouter ?");
            System.out.println("1-Ordinateur");
            System.out.println("2-Vélo");
            System.out.println("3-SmartPhone");
            choice = scanner.nextLine();
        }while (!Pattern.matches("[1-3]", choice));
        switch (choice) {
            case "1":
                createComputer();
                break;
            case "2":
                createBicycle();
                break;
            case "3":
                createSmartPhone();
                break;
        }
    }
    private void createComputer(){
        System.out.println("Ajout d'ordinateur");
        System.out.print("1ere étape ajouter le processeur: ");
        String processor = scanner.nextLine();
        System.out.print("2ème étape ajouter le nombre de mémoire ram en (giga) :");
        boolean error;
        int ram = 0;
        do {
            try {
                ram = Integer.parseInt(scanner.nextLine());
                error = false;
            }catch (NumberFormatException e){
                System.out.print("Erreur, Veuillez saisir un entier ! :");
                error = true;
            }
        }while (error);
        System.out.print("Derniere étape veuillez saisir la carte graphique :");
        String graphicCard = scanner.nextLine();
        Product product = new ComputerFactory()
                .createProduct(
                        new Computer.ComputerBuilder()
                                .processor(processor)
                                .graphicCard(graphicCard)
                                .memoryRam(ram)
                );
        products.add(product);
        System.out.println("Ajout du produit avec succés:" + product);
    };
    private void createBicycle(){
        System.out.println("Ajout de vélo");
        System.out.print("1ere étape ajouter la couleur: ");
        String color = scanner.nextLine();
        System.out.print("derniere étape ajouter le type de roue:");
        String tyreType = scanner.nextLine();
        Product product = new BicycleFactory()
                .createProduct(
                        new Bicycle.BicycleBuilder().color(color).tyreType(tyreType)
                );
        products.add(product);
        System.out.println("Ajout du produit avec succés:" + product);
    }
    private void createSmartPhone(){
        System.out.println("Ajout de smartphone");
        System.out.print("1ere étape ajouter la couleur: ");
        String color = scanner.nextLine();
        System.out.print("2ème étape ajouter le model:");
        String model = scanner.nextLine();
        System.out.print("3ème étape ajouter la taille du smartpone (en pouce)");
        boolean error;
        double inch = 0;
        do {
            try {
                inch = Double.parseDouble(scanner.nextLine());
                error = false;
            }catch (NumberFormatException e){
                System.out.print("Erreur, Veuillez saisir un décimal ! :");
                error = true;
            }
        }while (error);
        System.out.print("Dernière étape ajouter le système d'exploitation");
        String os = scanner.nextLine();
        Product product = new BicycleFactory()
                .createProduct(
                        new SmartPhone.SmartPhoneBuilder()
                                .color(color)
                                .model(model)
                                .inch(inch)
                                .os(os)
                );
        products.add(product);
        System.out.println("Ajout du produit avec succés:" + product);
    }
    private void showProductList(){
        if (products.isEmpty()){
            System.out.println("Aucun produit enregistré");
        }else{
            products.forEach(System.out::println);
        }

    }
}
