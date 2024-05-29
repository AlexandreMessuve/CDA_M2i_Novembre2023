package org.example.DAO;

import org.example.entity.Animal;
import org.example.entity.EnclosAnimal;
import org.example.util.DatabaseManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnclosAnimalDAO extends BaseDAO<EnclosAnimal>{
    @Override
    public EnclosAnimal save(EnclosAnimal element) throws SQLException {
        try{
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO enclos_animal (id_animal,id_enclos) VALUE (?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,element.getId_animal());
            statement.setInt(2,element.getId_enclos());
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
    public boolean delete(EnclosAnimal element) throws SQLException {
        return false;
    }

    @Override
    public EnclosAnimal update(EnclosAnimal element) throws SQLException {
        return null;
    }

    @Override
    public EnclosAnimal get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<EnclosAnimal> get() throws SQLException {
        return null;
    }

    public List<Animal> getAnimalByEnclosId (int id)throws SQLException{
        connection = DatabaseManager.getConnection();
          List<Animal> animals = new ArrayList<>();
          request = "SELECT a.id as animalId, a.name as animalName, a.race as AnimalRace, a.description as animalDesc, a.habitat as animalHab, a.age as animalAge FROM animal as a INNER JOIN enclos_animal as e ON e.id_animal = a.id WHERE e.id_enclos = ?";
          statement = connection.prepareStatement(request);
          statement.setInt(1,id);
          resultSet = statement.executeQuery();
          while(resultSet.next()){
              animals.add(Animal.builder()
                      .id(resultSet.getInt("animalId"))
                      .name(resultSet.getString("animalName"))
                      .race(resultSet.getString("AnimalRace"))
                      .description(resultSet.getString("animalDesc"))
                      .habitat(resultSet.getString("animalHab"))
                      .age(resultSet.getInt("animalAge"))
                      .build());
          }

          return animals;
    }
}
