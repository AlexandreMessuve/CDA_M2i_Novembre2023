package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Pot {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_pot")
//    private int id;
//
    private int height;

    private int width;
//
//    @OneToOne(mappedBy = "pot")
//    private Plante plante;

}
