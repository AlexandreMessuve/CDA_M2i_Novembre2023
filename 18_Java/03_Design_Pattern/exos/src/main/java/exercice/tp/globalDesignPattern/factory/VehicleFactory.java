package exercice.tp.globalDesignPattern.factory;

import exercice.tp.globalDesignPattern.entity.Vehicle;

public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String name, int position, int speed, int weight);
}
