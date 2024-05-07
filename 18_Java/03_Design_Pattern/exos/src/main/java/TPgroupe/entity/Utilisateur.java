package TPgroupe.entity;
import TPgroupe.observer.Observer;
import lombok.Data;

import java.util.UUID;

@Data
public class Utilisateur implements Observer {
    protected UUID id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    
    public Utilisateur(String nom, String prenom, String email, String motDePasse) {
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }


    @Override
    public void updateRessource(Ressource ressource) {
        System.out.println("Une nouvelle ressource a été créée" +
    }

    @Override
    public void updateCours(Cours cours) {

    }
}
