package repository;

import entity.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientRepository extends BaseRepository<Client> {
    public ClientRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Client findById(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }

}
