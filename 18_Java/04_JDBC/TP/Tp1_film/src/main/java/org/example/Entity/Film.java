package org.example.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Film {
    private int id;
    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", genre='" + genre + '\'' +
                '}';
    }
}
