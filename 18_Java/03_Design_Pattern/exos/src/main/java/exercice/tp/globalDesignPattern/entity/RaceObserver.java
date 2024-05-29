package exercice.tp.globalDesignPattern.entity;

public class RaceObserver implements Observer{
    @Override
    public void update(Vehicle vehicle) {
        switch (vehicle.getClass().getSimpleName()){
            case "Car":
                Car car = (Car) vehicle;
                System.out.println(car.getName() +" Position: " + car.getPosition());
                break;
            case "Truck":
                Truck truck = (Truck) vehicle;
                System.out.println(truck.getName() +" Position: " + truck.getPosition());
                break;
            case "MotorBike":
                MotorBike motorBike = (MotorBike) vehicle;
                System.out.println(motorBike.getName() +" Position: " + motorBike.getPosition());
                break;
        }
    }
}
