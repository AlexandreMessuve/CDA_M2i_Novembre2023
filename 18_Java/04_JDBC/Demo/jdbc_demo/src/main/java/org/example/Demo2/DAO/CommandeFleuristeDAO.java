package org.example.Demo2.DAO;

import org.example.Demo2.Entity.Commande;
import org.example.Demo2.Entity.CommandeFleuriste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandeFleuristeDAO extends BaseDAO<CommandeFleuriste> {

    private PlanteDAO planteDAO;

    public CommandeFleuristeDAO(Connection connection) {
        super(connection);
        planteDAO = new PlanteDAO(connection);
    }

    @Override
    public CommandeFleuriste save(CommandeFleuriste element) throws SQLException {
        try{
            request = "INSERT INTO commande_fleuriste (id_commande,id_fleuriste) VALUE (?,?)";
            preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,element.getId_commande());
            preparedStatement.setInt(2,element.getId_fleuriste());
            int nbrow = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if(nbrow != 1){
                throw new SQLException();
            }
            if(resultSet.next()){
                element.setId(resultSet.getInt(1));
            }
            _connection.commit();
            return element;
        }catch(SQLException e){
            _connection.rollback();
            return null;
        }
    }

    @Override
    public CommandeFleuriste update(CommandeFleuriste element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(CommandeFleuriste element) throws SQLException {
        return false;
    }

    @Override
    public CommandeFleuriste get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CommandeFleuriste> get() throws SQLException {
        return null;
    }

    public List<Commande> getAllCommandeByFleuristeId (int id)throws SQLException{
        List<Commande> commandes = new ArrayList<>();
        request ="SELECT c.id as commandeId , c.prix as commandePrix, c.quantite as commandeQuantite , c.plante_id as commandePlanteId  FROM commande AS c INNER JOIN commande_fleuriste as f ON f.id_commande = c.id WHERE f.id_fleuriste = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            commandes.add(Commande.builder().id(resultSet.getInt("commandeId"))
                    .prix(resultSet.getFloat("commandePrix"))
                    .quantite(resultSet.getInt("commandeQuantite"))
                    .plante(planteDAO.get(resultSet.getInt("commandePlanteId")))
                    .build());
        }
        return commandes;
    }
}
