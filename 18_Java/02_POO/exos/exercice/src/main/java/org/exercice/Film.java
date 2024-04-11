package org.exercice;

import java.time.LocalDate;

public class Film {
    private String title;
    private String real;
    private LocalDate releaseDate;
    private String genre;


    public Film(String title, String real, LocalDate releaseDate, String genre) {
        this.title = title;
        this.real = real;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Titre : " + getTitle() +
                "\n Realisateur : " + getReal() +
                "\n Date de sortie: " + getReleaseDate()+
                "\n Genre : " + getGenre();
    }
}
