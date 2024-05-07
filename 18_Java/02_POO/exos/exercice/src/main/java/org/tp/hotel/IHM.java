package org.tp.hotel;

import org.tp.hotel.model.Client;
import org.tp.hotel.model.Hotel;
import org.tp.hotel.model.Reservation;
import org.tp.hotel.model.Room;

import java.util.*;
import java.util.regex.Pattern;

public class IHM {
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private Hotel hotel;
    public void start(){
        System.out.println("#################################");
        System.out.println("Bienvenu dans la gestion d'hotel");
        System.out.println("#################################");
        String hotelName = control("Veuillez saisir le nom de l'hotel: ", "[A-Za-z]+");
        hotel = new Hotel(hotelName);
        createRandomRoom(rand.nextInt(15,40));
        System.out.println("#################################");
        System.out.println("Hotel créé avec succés");
        menu();
    }

    private void menu(){
        String choice;
        do {
            System.out.println("#################################");
            System.out.println("1- Ajouter un client");
            System.out.println("2- Afficher la liste des clients");
            System.out.println("3- Afficher les réservations d'un client");
            System.out.println("4- Ajouter une réservation");
            System.out.println("5- Annuler une réservation");
            System.out.println("6- Afficher la liste des réservations");
            System.out.println("0- Quitter le programme");
            System.out.print("Saisir votre choix : ");
            System.out.println("#################################");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(addClient());
                    break;
                case "2":
                    showClients();
                    break;
                case "3":
                    showReservationsClient();
                    break;
                case "4":
                    addReservation();
                    break;
                case "5":
                    cancelReservation();
                    break;
                case "6":
                    showReservations();
                    break;
            }
        }while (!choice.equalsIgnoreCase("0"));

        System.out.println("#################################");
        System.out.println("########Fin du programme#########");
        System.out.println("#################################");
    }

    private String addClient(){
        System.out.println("Creation du client");
        String lastname = control("Veuillez saisir le nom du client", "[A-Za-z]+");
        String firstname = control("Veuillez saisir le prénom du client","[A-Za-z]+");
        String phoneNumber = control("Veuillez saisir le numéro de téléphone du client", "[0-9]{10}");
        Client newClient = new Client(firstname, lastname, phoneNumber);
        hotel.addClient(newClient);
        return "Ajouter avec success";
    }
    private void showClients(){
        System.out.println("Liste des clients : ");
        List<Client> clients = hotel.getClients();
        if (clients.isEmpty()){
            System.out.println("Aucun client enregistré");
        }else{
            clients.forEach(System.out::println);
        }
    }
    private void showReservationsClient(){
        showClients();
        String lastname = control("Saisir le nom du client", "[a-zA-Z]+");
        List<Reservation> reservations = hotel.getReservations();
        List<Reservation> reservationListClient = reservations.stream()
                .filter(reservation -> reservation.getClient().getLastName().equalsIgnoreCase(lastname))
                .toList();
        if (reservationListClient.isEmpty()){
            System.out.println("Aucune réservation pour ce client");
        }else {
            System.out.println("Liste des réservations :");
            reservationListClient.forEach(System.out::println);
        }
     }
    private void createRandomRoom(int nbRooms){
        for (int i = 0; i < nbRooms; i++){
            Room room = new Room(rand.nextDouble(5,50),rand.nextInt(1,4));
            hotel.addRoom(room);
        }
    }
    private String control(String message, String regex){
        System.out.print(message);
        String choice = scanner.nextLine();
        while (!Pattern.matches(regex,choice)){
            System.out.printf("Erreur ! %s", message);
            choice = scanner.nextLine();
        }
        return choice;
    }
}
