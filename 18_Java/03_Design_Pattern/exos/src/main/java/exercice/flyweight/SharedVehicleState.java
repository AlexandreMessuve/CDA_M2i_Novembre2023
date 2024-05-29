package exercice.flyweight;

public class SharedVehicleState implements VehicleFlyWeight{
    private String model;
    private String color;

    public SharedVehicleState(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void displayInfoVehicle(String marque) {
        System.out.println(marque);
        System.out.println(model);
        System.out.println(color);
    }
}
