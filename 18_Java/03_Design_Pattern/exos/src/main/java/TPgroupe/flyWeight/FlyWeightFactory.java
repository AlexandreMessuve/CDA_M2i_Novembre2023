package TPgroupe.flyWeight;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;

public class FlyWeightFactory {
    Map<UUID, SharedRessourceState> flyweights = new HashMap<>();

    public SharedRessourceState getFlyweight(String title, String contenu, String description) {
        UUID uuid = UUID.randomUUID();
        if(!flyweights.containsKey(uuid)) {
            flyweights.put(uuid, new SharedRessourceState(title, contenu, description));
        }
        return flyweights.get(uuid);
    }

}
