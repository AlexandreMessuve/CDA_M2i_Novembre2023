package TPgroupe.observer;

import TPgroupe.entity.Cours;
import TPgroupe.entity.Ressource;

public interface Observer {
    void updateRessource(Ressource ressource);
    void updateCours(Cours cours);
}
