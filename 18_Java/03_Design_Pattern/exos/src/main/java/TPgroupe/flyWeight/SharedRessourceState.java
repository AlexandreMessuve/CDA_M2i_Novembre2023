package TPgroupe.flyWeight;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder

public class SharedRessourceState implements RessourceFlyWeight{
    private String title;
    private String contenu;
    private String description;

    @Override
    public void visualiser(String auteur) {
        System.out.println(auteur);
        System.out.println(title);
        System.out.println(contenu);
        System.out.println(description);
    }
}
