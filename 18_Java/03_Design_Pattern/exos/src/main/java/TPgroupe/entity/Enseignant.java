package TPgroupe.entity;

import java.util.Optional;
import java.util.Stack;
import java.util.UUID;

public class Enseignant extends Utilisateur{
    public Enseignant(String nom, String prenom, String mail, String motDePasse) {
        super(nom, prenom, mail, motDePasse);

    }

    public Cours addCours(String sujet , String contenu){
        Cours cours = Cours.builder().sujet(sujet).contenu(contenu).build(); // creation du cours
        return cours;
    }

    public Cours updateCours(UUID idCours, String sujet, String contenu){
       Optional<Cours> cours = Cours.listeCours.stream().filter(c -> c.getId() == idCours).findFirst(); // récupere le cours avec son id
       if (cours.isPresent()) { // verifie si il est present
           Cours updateCours = cours.get();
           //Modification du contenu
           updateCours.setSujet(sujet);
           updateCours.setContenu(contenu);
           //Retourne le cours
           return updateCours;
       }else {
           // return null
           return null;
       }

    }

    public deleteCours(UUID idCours, String sujet , String contenu){
        Optional<Cours> cours = Cours.listeCours.stream().filter(c -> c.getId() == idCours).findFirst(); // récupere le cours avec son id
    }

    
}
