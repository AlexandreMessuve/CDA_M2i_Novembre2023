package org.example.DAO;

import org.example.entity.Enclos;
import org.example.entity.Meal;
import org.example.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class EncloDAO extends BaseDAO<Enclos> {

    private EnclosAnimalDAO enclosAnimalDAO;

    public EncloDAO( ) {
        this.enclosAnimalDAO = new EnclosAnimalDAO();
    }

    @Override
    public Enclos save(Enclos element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO enclos (name) VALUE (?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,element.getName());
            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(row != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            connection.rollback();
            return null;
        }finally {
            close();
        }
    }

    @Override
    public boolean delete(Enclos element) throws SQLException {
        return false;
    }

    @Override
    public Enclos update(Enclos element) throws SQLException {
        return null;
    }

    @Override
    public Enclos get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Enclos> get() throws SQLException {
        try{
            List<Enclos> enclos = new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM enclos";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                enclos.add(Enclos.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .animals(enclosAnimalDAO.getAnimalByEnclosId(resultSet.getInt("id")))
                        .build());
            }
            return enclos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }finally {
            close();
        }
    }
}
