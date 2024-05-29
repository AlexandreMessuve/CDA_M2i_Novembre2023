package org.example.Demo2.Util;

import org.example.Demo2.DAO.CommandeDAO;
import org.example.Demo2.DAO.CommandeFleuristeDAO;
import org.example.Demo2.DAO.FleuristeDao;
import org.example.Demo2.DAO.PlanteDAO;
import org.example.Demo2.Entity.Commande;
import org.example.Demo2.Entity.CommandeFleuriste;
import org.example.Demo2.Entity.Fleuriste;
import org.example.Demo2.Entity.Plante;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private Connection connection;
    private PlanteDAO planteDAO;
    private CommandeDAO commandeDAO;
    private FleuristeDao fleuristeDao;
    private CommandeFleuristeDAO commandeFleuristeDAO;

    private Scanner scanner;

    public Ihm (){
        scanner = new Scanner(System.in);
        try{
            connection = DataBaseManager.getConnection();
            planteDAO = new PlanteDAO(connection);
            commandeDAO = new CommandeDAO(connection,planteDAO);
            fleuristeDao = new FleuristeDao(connection);
            commandeFleuristeDAO = new CommandeFleuristeDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void start (){
        int entry ;
        while(true){
            System.out.println("--- Gestion de Plante ---");
            System.out.println("1/ Creation de plante");
            System.out.println("2/ afficher toutes les plantes");
            System.out.println("3/ ajouter une commande");
            System.out.println("4/ commande par l'id");
            System.out.println("5/cree un fleuriste");
            System.out.println("6/ assigner une commande a un fleuriste");
            System.out.println("7/all fleuriste");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1 :
                    createPlante();
                    break;
                case 2:
                    getAllPlante();
                    break;
                case 3:
                    addCommande();
                    break;
                case 4:
                    commandeById();
                    break;
                case 5:
                    createFleuriste();
                    break;
                case 6:
                    assignCommand();
                    break;
                case 7:
                    geTAllFleuriste();
                    break;
                default:
                    return;
            }
        }
    }

    private void createPlante (){
        System.out.println("--- creation de plante ---");
        System.out.println("nom de la plante :");
        String name = scanner.nextLine();
        System.out.println("couleur de la plante:");
        String color = scanner.nextLine();
        System.out.println("age de la plante :");
        int age =  scanner.nextInt();
        scanner.nextLine();
        try{

            Plante plante =planteDAO.save(Plante.builder().name(name).color(color).age(age).build());
            System.out.println("la plante a ete cree" + plante);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private void createFleuriste (){
        System.out.println("--- creation de fleuriste ---");
        System.out.println("nom du fleuriste :");
        String name = scanner.nextLine();

        try{

            Fleuriste fleuriste = fleuristeDao.save( Fleuriste.builder().name(name).build());
            System.out.println("le fleuriste a ete cree" + fleuriste);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void geTAllFleuriste (){
        try {
            System.out.println("-- afficher un fleuriste --");
            System.out.println("id du fleuriste");
            int id = scanner.nextInt();
            scanner.nextLine();
            Fleuriste fleuriste = fleuristeDao.get(id);
            System.out.println(fleuriste);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void assignCommand  (){
        System.out.println("--- assigner une commande a un fleuriste ---");
        System.out.println("id du fleuriste :");
        int id_fleuriste = scanner.nextInt();
        scanner.nextLine();

        System.out.println("id du commande :");
        int id_commande = scanner.nextInt();
        scanner.nextLine();

        try{

            CommandeFleuriste commandeFleuriste = commandeFleuristeDAO.save(CommandeFleuriste.builder().id_fleuriste(id_fleuriste).id_commande(id_commande).build());
            System.out.println("le fleuriste a ete assigner a la commande" + commandeFleuriste);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void getAllPlante (){
        try {
            List<Plante> plantes = planteDAO.get();
            for(Plante plante : plantes){
                System.out.println(plante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void addMultiplePlante(){
        List<Plante> plantes = new ArrayList<>();
        plantes.add(Plante.builder().name("coquelicot").color("red").age(0).build());
        plantes.add(Plante.builder().name("poisBleu").color("blue").age(1).build());

        planteDAO.multipleAdd(plantes);
    }

    public void addCommande (){
        System.out.println("-- ajout de commande --");
        System.out.println("prix de la commande :");
        float prix = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("quantité de la commande");
        int quantite = scanner.nextInt();
        scanner.nextLine();
        System.out.println("id de la plante de la commande :");
        int idPlante = scanner.nextInt();
        scanner.nextLine();

        try {
            Commande commande = Commande.builder().prix(prix).quantite(quantite).plante(planteDAO.get(idPlante)).build();
            Commande commandeCreated = commandeDAO.save(commande);
            System.out.println("la commande a ete cree" + commandeCreated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void commandeById(){
        System.out.println("-- recuperer une commande par son id --");
        System.out.println("id de la commande a recuperer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.println(commandeDAO.get(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
