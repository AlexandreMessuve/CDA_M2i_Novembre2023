package org.bank;

public class Client {
    private final int id;
    private String lastname;
    private String firstname;
    private String phone;
    private BankAccount[] bankAccounts;
    private static int nbClients = 0;

    public Client(String firstname, String lastname, String phone) {
        this.id = ++nbClients;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getNbClients() {
        return nbClients;
    }
}
