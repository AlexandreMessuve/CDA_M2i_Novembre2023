package org.example.Util;

import org.example.DAO.FilmDAO;
import org.example.Entity.Film;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private FilmDAO filmDAO;
    private Scanner scanner;

    public Ihm (){
        scanner = new Scanner(System.in);
        filmDAO = new FilmDAO();

    }

    public void start (){
        int entry;
        while (true){
            System.out.println("--- gestion de film ---");
            System.out.println("1/ cree un film");
            System.out.println("2/ update film");
            System.out.println("3/ supprimer un film");
            System.out.println("4/ afficher tout les films");

            entry = scanner.nextInt();
            scanner.nextLine();
            switch (entry){
                case 1:
                    creatFilm();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    deleteFilm();
                    break;
                case 4 :
                    getAllFilm();
                    break;
                default:
                    return;
            }
        }
    }

    private void creatFilm (){
        System.out.println("-- creation d'un film --");
        System.out.println("titre du film :");
        String title = scanner.nextLine();
        System.out.println("realisateur du film :");
        String realisateur = scanner.nextLine();
        System.out.println("genre du film");
        String genre = scanner.nextLine();
        System.out.println("Date de sortie du film");
        System.out.println("Année de sortie du film :");
        int year =  scanner.nextInt();
        scanner.nextLine();
        System.out.println("mois de sortie du film ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println("jour de la sortie du film");
        int day = scanner.nextInt();
        scanner.nextLine();
        LocalDate dateDeSortie = LocalDate.of(year,month,day);

        try {
            System.out.println(filmDAO.save(Film.builder().titre(title).realisateur(realisateur).genre(genre).dateSortie(dateDeSortie).build()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void update (){
        System.out.println("--- modification d'un film ---");
        System.out.println("id du film :");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Film film = filmDAO.get(id);
            System.out.println("titre du film ("+film.getTitre()+")");
            String titre = scanner.nextLine();

            System.out.println("realisateur du film ("+film.getRealisateur()+")");
            String realisateur = scanner.nextLine();

            System.out.println("Genre du film ("+film.getGenre()+")");
            String genre = scanner.nextLine();

            System.out.println("Date de sortie du film ("+film.getDateSortie().toString()+")");
            System.out.println("Année de sortie du film :");
            int year =  scanner.nextInt();
            scanner.nextLine();
            System.out.println("mois de sortie du film ");
            int month = scanner.nextInt();
            scanner.nextLine();
            System.out.println("jour de la sortie du film");
            int day = scanner.nextInt();
            scanner.nextLine();
            LocalDate dateDeSortie = LocalDate.of(year,month,day);

            try {
                System.out.println("film mis a jour "+filmDAO.update(filmDAO.save(Film.builder().titre(titre).realisateur(realisateur).genre(genre).dateSortie(dateDeSortie).id(id).build())));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFilm (){
        System.out.println("--- suppresion d'un film ---");
        System.out.println("id du film a supprimer");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
             if(filmDAO.delete(id)){
                 System.out.println("film supprimé");
             }else{
                 System.out.println("erreur lors de la suppresion");
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAllFilm (){
        System.out.println("--- afficher les films ---");
        try {
            List<Film> films = filmDAO.get();
            for(Film film : films){
                System.out.println(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
