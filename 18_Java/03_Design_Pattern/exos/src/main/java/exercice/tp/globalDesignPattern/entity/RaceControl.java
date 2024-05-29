package exercice.tp.globalDesignPattern.entity;

import exercice.tp.globalDesignPattern.factory.CarFactory;
import exercice.tp.globalDesignPattern.factory.MotorBikeFactory;
import exercice.tp.globalDesignPattern.factory.TruckFactory;
import exercice.tp.globalDesignPattern.factory.VehicleFactory;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
public class RaceControl {
    private static List<Vehicle> vehicleList;
    private static RaceControl instance;
    private static Random random = new Random();

    private RaceControl(){
        vehicleList = new ArrayList<>();
        createVehicles();
    }

    public static synchronized RaceControl getRaceControl(){
        if(instance == null){
            instance = new RaceControl();
        }
        return instance;
    }

    //Création des véhicule de façon random LUL
    private static void createVehicles() {
        CarFactory carFactory = new CarFactory();
        TruckFactory truckFactory = new TruckFactory();
        MotorBikeFactory motorBikeFactory = new MotorBikeFactory();
        List<VehicleFactory> vehicleFactories = new ArrayList<>();
        vehicleFactories.add(motorBikeFactory);
        vehicleFactories.add(truckFactory);
        vehicleFactories.add(carFactory);
        for (int i = 0; i < 5; i++) {
            VehicleFactory factoryRandom = vehicleFactories.get(random.nextInt(vehicleFactories.size()));
            String name = "Vehicle " + (i + 1);
            int position = i + 1;
            int weight = 0;
            int speed = 10;
            switch(factoryRandom.getClass().getSimpleName()){
                case "CarFactory":
                    weight = random.nextInt(1,6);
                    break;
                case "TruckFactory":
                    weight = random.nextInt(2,6);
                    break;
                case "MotorBikeFactory":
                    weight = random.nextInt(1,3);
                    break;
            }
            Vehicle vehicle = factoryRandom.createVehicle(name, position, speed, weight);
            vehicleList.add(vehicle);
        }
    }
    private static<Vehicle> void shuffle(List<Vehicle> list)
    {
        Random random = new Random();

        // start from the end of the list
        for (int i = list.size() - 1; i >= 1; i--)
        {
            // get a random index `j` such that `0 <= j <= i`
            int j = random.nextInt(i + 1);

            // swap element at i'th position in the list with the element at
            // randomly generated index `j`
            Collections.swap(list, i, j);



        }
    }
    private void changePosition(){
        for(int i = 0; i < vehicleList.size(); i++){
            Vehicle vehicle = vehicleList.get(i);
            switch (vehicle.getClass().getSimpleName()){
                case "Car":
                    Car car = (Car) vehicle;
                    car.setPosition(i+1);
                    break;
                case "Truck":
                    Truck truck = (Truck) vehicle;
                    truck.setPosition(i+1);
                    break;
                case "MotorBike":
                    MotorBike motorBike = (MotorBike) vehicle;
                    motorBike.setPosition(i+1);
                    break;
            }
        }
    }
    public void test(){
        shuffle(vehicleList);
        changePosition();
    }
}
