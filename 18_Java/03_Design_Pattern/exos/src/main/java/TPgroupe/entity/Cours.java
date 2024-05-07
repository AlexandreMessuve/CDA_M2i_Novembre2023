package TPgroupe.entity;

import java.util.*;
import TPgroupe.subject.Subject;
import TPgroupe.observer.Observer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Cours implements Subject {
    private UUID id;
    private String sujet;
    private String contenu;
    private Date dateDeCreation;
    private Date dateDeModification;
    List<Observer> collectionObserversCours;
    static List<Cours> listeCours;
    List<Quiz> listeQuiz;
    
    @Override
    public void registerObserver(Observer observer) {

        collectionObserversCours.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        collectionObserversCours.remove(observer);
    }

    @Override
    public void notifyObservers() {

    }
}
