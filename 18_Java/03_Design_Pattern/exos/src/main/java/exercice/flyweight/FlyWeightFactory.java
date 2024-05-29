package exercice.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
    private Map<String, SharedVehicleState> flyweights = new HashMap<>();

    public SharedVehicleState getFlyweight(String model, String color) {
        String key = model + "|" + color;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new SharedVehicleState(model, color));
        }
        return flyweights.get(key);
    }
}
