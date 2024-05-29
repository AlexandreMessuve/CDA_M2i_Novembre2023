package exercice.flyweight;

import lombok.Data;

@Data
public class Vehicle {
    private String marque;
    private VehicleFlyWeight vehicleFlyWeight;
    public Vehicle(String marque, VehicleFlyWeight vehicleFlyWeight) {
        this.marque = marque;
        this.vehicleFlyWeight = vehicleFlyWeight;
    }

    public void showInfo(){
        vehicleFlyWeight.displayInfoVehicle(marque);
    }
}
