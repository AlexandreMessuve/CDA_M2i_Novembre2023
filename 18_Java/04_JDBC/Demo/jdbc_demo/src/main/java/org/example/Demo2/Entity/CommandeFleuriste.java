package org.example.Demo2.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFleuriste {
    private int id;
    private int id_fleuriste;
    private int id_commande;
}
