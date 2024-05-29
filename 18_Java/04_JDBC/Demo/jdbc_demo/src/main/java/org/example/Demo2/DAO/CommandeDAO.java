package org.example.Demo2.DAO;

import org.example.Demo2.Entity.Commande;
import org.example.Demo2.Entity.Plante;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends BaseDAO<Commande> {

    private PlanteDAO plantesDAO;

    public CommandeDAO(Connection connection, PlanteDAO planteDAO) {
        super(connection);
        plantesDAO = planteDAO;
    }

    @Override
    public Commande save(Commande element) throws SQLException {
        try{
            request = "INSERT INTO commande (prix,quantite,plante_id) VALUE (?,?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setFloat(1,element.getPrix());
            preparedStatement.setInt(2,element.getQuantite());
            preparedStatement.setInt(3,element.getPlante().getId_plante());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            Commande commande = null;
            if(resultSet.next()){
                commande = Commande.builder().prix(element.getPrix()).quantite(element.getQuantite()).plante(element.getPlante()).id(resultSet.getInt(1)).build();
            }
            if(nbrow != 1){
                _connection.rollback();
            }
            _connection.commit();
            return commande;
        }catch(SQLException e){
            _connection.rollback();
            return null;
        }
    }

    @Override
    public Commande update(Commande element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Commande element) throws SQLException {
        return false;
    }

    @Override
    public Commande get(int id) throws SQLException {
        request = "SELECT * FROM commande WHERE id = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return Commande.builder().id(resultSet.getInt("id"))
                    .prix(resultSet.getFloat("prix"))
                    .quantite(resultSet.getInt("quantite"))
                    .plante(plantesDAO.get(resultSet.getInt("plante_id")))
                    .build();
        }
        return null;
    }

    @Override
    public List<Commande> get() throws SQLException {
        return null;
    }


}
