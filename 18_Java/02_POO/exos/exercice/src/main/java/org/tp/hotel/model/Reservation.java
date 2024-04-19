package org.tp.hotel.model;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final UUID number;
    private Status state;
    private final Client client;
    private final Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(Client client, Room room, LocalDate startDate, LocalDate endDate) {
        this.number = UUID.randomUUID();
        this.state = Status.CONFIRMED_RESERVED;
        this.client = client;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        return room.getPrice() * days;
    }
    @Override
    public String toString() {
        String status  = "";
        if(state == Status.CONFIRMED_RESERVED) {
            status = "CONFIRMED";
        }else{
            status = "CANCELLED";
        }
        return "Reservation ID=" + number +
                "\n state=" + status +
                "\n client=" + client.toString() +
                "\n room=" + room.toString() +
                "\n startDate=" + startDate.toString() +
                "\n endDate=" + endDate.toString()+
                "\n totalPrice=" + getTotalPrice();
    }
}
