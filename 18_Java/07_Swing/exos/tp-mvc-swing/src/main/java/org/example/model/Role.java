package org.example.model;

public enum Role {
    MANAGER,EMPLOYEE,RH;


    @Override
    public String toString() {
        return switch (this) {
            case MANAGER -> "Manager";
            case EMPLOYEE -> "Employee";
            case RH -> "RH";
        };
    }
}
