package org.tp.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private final List<Reservation> reservations = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();

    public Hotel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    public List<Client> getClients() {
        return clients;
    }
    public void addClient(Client client) {
        clients.add(client);
    }
    public List<Room> getRooms() {
        return rooms;
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

}
