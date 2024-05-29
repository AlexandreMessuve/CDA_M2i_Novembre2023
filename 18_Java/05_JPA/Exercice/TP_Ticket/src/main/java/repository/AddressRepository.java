package repository;

import entity.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class AddressRepository extends BaseRepository<Address> {

    public AddressRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Address findById(int id) {
        return em.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        return em.createQuery("select a from Address a", Address.class).getResultList();
    }
}
