package exercice.zoo.dao;

import exercice.zoo.entity.Animal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO extends BaseDAO<Animal>{
    public AnimalDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Animal save(Animal element) throws SQLException {
        try{
            request = "INSERT INTO animal (name, type, age, description, habitat) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, element.getName());
            preparedStatement.setString(2, element.getType());
            preparedStatement.setInt(3, element.getAge());
            preparedStatement.setString(4, element.getDescription());
            preparedStatement.setString(5, element.getHabitat());
            int nbRow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Animal animal = null;
            if(resultSet.next()){
                animal = Animal.builder()
                        .name(element.getName())
                        .type(element.getType())
                        .age(element.getAge())
                        .description(element.getDescription())
                        .habitat(element.getHabitat())
                        .id(resultSet.getInt(1))
                        .build();
            }
            if (nbRow != 1) {
                _connection.rollback();
            }
            _connection.commit();
            return animal;
        }catch (SQLException e){
            _connection.rollback();
            return null;
        }
    }

    @Override
    public Animal update(Animal element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Animal element) throws SQLException {
        return false;
    }

    @Override
    public Animal get(int id) throws SQLException {
        try {
         request = "SELECT * FROM animal WHERE id = ?";
         preparedStatement = _connection.prepareStatement(request);
         preparedStatement.setInt(1, id);
         resultSet = preparedStatement.executeQuery();
         Animal animal = null;
         if(resultSet.next()){
             animal = Animal.builder().id(resultSet.getInt("id"))
                     .name(resultSet.getString("name"))
                     .type(resultSet.getString("type"))
                     .age(resultSet.getInt("age"))
                     .description(resultSet.getString("description"))
                     .habitat(resultSet.getString("habitat"))
                     .build();
         }
         return animal;
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public List<Animal> get() throws SQLException {
       try {
           List<Animal> animals = new ArrayList<>();
           request = "SELECT * FROM animal";
           preparedStatement = _connection.prepareStatement(request);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               animals.add(
                       Animal.builder().id(resultSet.getInt("id"))
                               .name(resultSet.getString("name"))
                               .type(resultSet.getString("type"))
                               .age(resultSet.getInt("age"))
                               .description(resultSet.getString("description"))
                               .habitat(resultSet.getString("habitat"))
                               .build());
           }
           return animals;
       }catch (SQLException e){
           return null;
       }
    }

    public void multipleAdd(List<Animal> animals){
        try {
            request = "INSERT INTO animal (name, type, age, description, habitat) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            for(Animal animal : animals){
                preparedStatement.setString(1, animal.getName());
                preparedStatement.setString(2, animal.getType());
                preparedStatement.setInt(3, animal.getAge());
                preparedStatement.setString(4, animal.getDescription());
                preparedStatement.setString(5, animal.getHabitat());

                preparedStatement.addBatch();
            }
            int[] result = preparedStatement.executeBatch();
            _connection.commit();

            System.out.println("Nombre de ligne insérées: " + result.length);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
