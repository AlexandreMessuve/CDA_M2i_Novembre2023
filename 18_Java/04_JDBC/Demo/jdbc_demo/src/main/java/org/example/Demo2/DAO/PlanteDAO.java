package org.example.Demo2.DAO;

import org.example.Demo2.Entity.Plante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanteDAO extends BaseDAO<Plante> {

    public PlanteDAO (Connection connection){
        super(connection);
    }

    @Override
    public Plante save(Plante element) throws SQLException {
        try{
            request = "INSERT INTO plante (name,color,age) VALUE (?,?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,element.getName());
            preparedStatement.setString(2,element.getColor());
            preparedStatement.setInt(3,element.getAge());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Plante plante = null;
            if(resultSet.next()){
                plante = Plante.builder().name(element.getName()).color(element.getColor()).age(element.getAge()).id_plante(resultSet.getInt(1)).build();
            }
            if(nbrow != 1){
                _connection.rollback();
            }
            _connection.commit();
            return plante;
        }catch(SQLException e){
            _connection.rollback();
            return null;
        }

    }

    @Override
    public Plante update(Plante element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Plante element) throws SQLException {
        return false;
    }

    @Override
    public Plante get(int id) throws SQLException {
        request = "SELECT * FROM plante WHERE id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return Plante.builder().id_plante(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .color(resultSet.getString("color"))
                    .age(resultSet.getInt("age"))
                    .build();
        }
        return null;
    }

    @Override
    public List<Plante> get() throws SQLException {
        List<Plante> plantes = new ArrayList<>();
        request = "SELECT * FROM plante";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            plantes.add(Plante.builder().id_plante(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .color(resultSet.getString("color"))
                    .age(resultSet.getInt("age"))
                    .build());
        }
        return plantes;
    }

    public void multipleAdd (List<Plante> plantes){
        try {
            request = "INSERT INTO plante (name,color,age) VALUE (?,?,?)";
            preparedStatement = _connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
            for(Plante plante : plantes){
                preparedStatement.setString(1,plante.getName());
                preparedStatement.setString(2,plante.getColor());
                preparedStatement.setInt(3,plante.getAge());

                preparedStatement.addBatch();
            }

            int[] result = preparedStatement.executeBatch();
            resultSet = preparedStatement.getGeneratedKeys();
            _connection.commit();
            System.out.println("nombre de ligne inserées :" +result.length);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
