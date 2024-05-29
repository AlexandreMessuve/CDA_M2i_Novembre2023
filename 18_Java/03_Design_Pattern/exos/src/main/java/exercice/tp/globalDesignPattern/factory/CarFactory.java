package exercice.tp.globalDesignPattern.factory;

import exercice.tp.globalDesignPattern.entity.Car;
import exercice.tp.globalDesignPattern.entity.Vehicle;

public class CarFactory extends VehicleFactory{
    @Override
    public Vehicle createVehicle(String name, int position, int speed, int weight) {
        return Car.builder().name(name).position(position).speed(speed).weight(weight).build();
    }
}
