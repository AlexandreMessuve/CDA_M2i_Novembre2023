package TPgroupe.entity;

import TPgroupe.flyWeight.RessourceFlyWeight;
import TPgroupe.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ressource {
    private UUID id;
    String auteur;
    RessourceFlyWeight ressourceFlyWeight;
    List<Observer> collectionObserversRessource;

    public Ressource(String auteur, RessourceFlyWeight ressourceFlyWeight) {
        this.auteur = auteur;
        this.ressourceFlyWeight = ressourceFlyWeight;
        this.collectionObserversRessource = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    void visualiser() {
        this.ressourceFlyWeight.visualiser(auteur);
    }


}
