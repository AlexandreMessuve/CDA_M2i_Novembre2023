package org.example.util.Ihm;

import org.example.DAO.EncloDAO;
import org.example.DAO.EnclosAnimalDAO;
import org.example.entity.Animal;
import org.example.entity.Enclos;
import org.example.entity.EnclosAnimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EnclosIhm {

    private Scanner scanner;

    private EncloDAO encloDAO;

    private EnclosAnimalDAO enclosAnimalDAO;

    public EnclosIhm (Scanner scanner){
        this.scanner = scanner;
        encloDAO = new EncloDAO();
        enclosAnimalDAO = new EnclosAnimalDAO();
    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu Enclos ---");
            System.out.println("1/ cree un enclos");
            System.out.println("2/ liee un animal a un enclos");
            System.out.println("3/ afficher tout les enclos");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createEnclos();
                    break;
                case 2:
                    linkAnimalToEnclos();
                    break;
                case 3 :
                    showAll();
                    break;
                default:
                    return;
            }
        }
    }


    private void createEnclos (){
        System.out.println("-- creation du enclos --");
        System.out.println("nom de l'enclos :");
        String name = scanner.nextLine();
        try {

            Enclos enclos = encloDAO.save(Enclos.builder().name(name).build());
            if(enclos != null){
                System.out.println("enclos cree "+ enclos );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void linkAnimalToEnclos (){
        System.out.println("-- liee un animal a un enclos --");
        System.out.println("id de l'animal :");
        int id_animal = scanner.nextInt();
        scanner.nextLine();
        System.out.println("id de l'enclos :");
        int id_enclos = scanner.nextInt();
        scanner.nextLine();

        try {
            EnclosAnimal enclosAnimal = enclosAnimalDAO.save(EnclosAnimal.builder().id_animal(id_animal).id_enclos(id_enclos).build());
            if(enclosAnimal != null){
                System.out.println("liaison cree "+ enclosAnimal );
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAll (){
        System.out.println("--- show all enclos ---");
        try {
            List<Enclos> enclos = encloDAO.get();
            for (Enclos enclo : enclos){
                System.out.println(enclo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
