package org.example.DAO;

import org.example.Entity.Film;
import org.example.Util.DatabaseManager;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FilmDAO extends BaseDAO<Film>{


    public FilmDAO(){

    }

    @Override
    public Film save (Film element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO film (titre,realisateur,date_de_sortie,genre) VALUE (?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getTitre());
            statement.setString(2,element.getRealisateur());
            statement.setDate(3,Date.valueOf(element.getDateSortie()));
            statement.setString(4,element.getGenre());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            Film film = null;
            if(resultSet.next()){
                film = Film.builder().titre(element.getTitre()).realisateur(element.getRealisateur()).dateSortie(element.getDateSortie()).genre(element.getGenre()).id(resultSet.getInt(1)).build();
            }
            connection.commit();
            return film;
        }catch(SQLException e){
            connection.rollback();
            return null;
        }finally {
            close();
        }

    }

    @Override
    public Film update (Film element) throws SQLException{
        try{
            connection = DatabaseManager.getConnection();
            request = "UPDATE film SET titre=?, realisateur = ?, date_de_sortie = ?, genre =? WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setString(1,element.getTitre());
            statement.setString(2,element.getRealisateur());
            statement.setDate(3,Date.valueOf(element.getDateSortie()));
            statement.setString(4, element.getGenre());
            statement.setInt(5,element.getId());
            if(statement.executeUpdate() == 1) {
                connection.commit();
                return element;
            }
            throw new SQLException();
        }catch (SQLException e){
            connection.rollback();
            return null;
        }finally {
            close();
        }

    }

    @Override
    public boolean delete (int id) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "DELETE FROM film WHERE id =?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            if(row ==1){
                connection.commit();
                return true;
            }
            return false;
        }catch (SQLException e){
            connection.rollback();
            return false;
        }finally {
            close();
        }
    }

    @Override
    public Film get(int id) throws SQLException {
        try{
            request = "SELECT * FROM film WHERE id = ?";
            statement = connection.prepareStatement(request);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return  Film.builder().titre(resultSet.getString("titre"))
                        .realisateur(resultSet.getString("realisateur"))
                        .dateSortie(resultSet.getDate("date_de_sortie").toLocalDate())
                        .genre(resultSet.getString("genre")).build();
            }
            return null;
        }catch (SQLException e){
            return  null;
        }finally {
            close();
        }
    }

    @Override
    public List<Film> get() throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            List<Film> films = new ArrayList<>();
            request = "SELECT * FROM film";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
               films.add(Film.builder().titre(resultSet.getString("titre"))
                        .realisateur(resultSet.getString("realisateur"))
                        .dateSortie(resultSet.getDate("date_de_sortie").toLocalDate())
                        .genre(resultSet.getString("genre")).build());
            }

            return films;
        }catch (SQLException e){
            return null;
        }finally {
            close();
        }
    }
}
