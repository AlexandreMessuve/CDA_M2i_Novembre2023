package org.example.Demo2.Entity;

import lombok.Builder;
import lombok.Data;
import org.example.Demo2.DAO.PlanteDAO;

@Data
@Builder
public class Commande {
    private int id;
    private float prix;
    private int quantite;
    private Plante plante;

}
