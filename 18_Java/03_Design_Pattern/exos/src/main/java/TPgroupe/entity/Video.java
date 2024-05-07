package TPgroupe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Video extends Ressource {
    private int duree;
    private String lien;

    @Override
    void visualiser() {
        System.out.println("Vous pouvez visionner la vidéo à cette adresse "+ lien);

    }
}
