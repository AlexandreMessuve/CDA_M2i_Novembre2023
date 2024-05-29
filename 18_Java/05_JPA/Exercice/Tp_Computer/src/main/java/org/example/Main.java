package org.example;

import org.example.Entity.Computer;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IHM ihm = new IHM();
        ihm.start();

    }

}