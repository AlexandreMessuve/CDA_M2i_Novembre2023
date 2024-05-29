package exercice.flyweight;

public class Main {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        Vehicle vehicle = new Vehicle("Toyota", factory.getFlyweight("GTI", "Blanc"));
        Vehicle vehicle1 = new Vehicle("Renault", factory.getFlyweight("GTI", "Blanc"));
        Vehicle vehicle2 = new Vehicle("Toyota", factory.getFlyweight("GTO", "Blanc"));

        vehicle1.showInfo();
        vehicle.showInfo();
        vehicle2.showInfo();
    }
}
