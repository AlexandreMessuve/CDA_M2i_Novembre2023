package TPgroupe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document extends Ressource {
    private String extension;

}
