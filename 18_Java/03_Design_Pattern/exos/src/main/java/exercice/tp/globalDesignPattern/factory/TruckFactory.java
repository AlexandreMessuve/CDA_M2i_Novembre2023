package exercice.tp.globalDesignPattern.factory;

import exercice.tp.globalDesignPattern.entity.Truck;
import exercice.tp.globalDesignPattern.entity.Vehicle;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String name, int position, int speed, int weight) {
        return Truck.builder().name(name).position(position).speed(speed).weight(weight).build();
    }
}
