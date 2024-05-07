package org.tp.hotel.model;

import java.text.DecimalFormat;

public class Room {
    private final int number;
    private Status state;
    private double price;
    private int bedNumber;
    private static int roomsNumber = 0;

    public Room(double price, int bedNumber) {
        this.number = ++roomsNumber;
        this.state = Status.FREE_ROOM;
        this.price = price;
        this.bedNumber = bedNumber;
    }

    public int getNumber() {
        return number;
    }

    public static int getRoomsNumber() {
        return roomsNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        String status = "";
        if (state == Status.FREE_ROOM) {
            status = "Free";
        }else{
            status = "Reserved";
        }
        return "Room n°"+ number +
                "\n Status=" + status +
                "\n Price=" + df.format(price)+
                "\n Beds=" + bedNumber;
    }
}
