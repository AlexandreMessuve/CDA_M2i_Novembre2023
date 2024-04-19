package org.tp.hotel.model;

import java.util.UUID;

public class Client {
    private final UUID id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;

    public Client(String firstName, String lastName, String telephoneNumber) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Firstname='" + firstName + '\n' +
                "Lastname='" + lastName + '\n' +
                "Tel='" + telephoneNumber;
    }
}
